package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.map


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.map.MapLifeCycle
import com.iyeongjoon.nicname.core.rx.fragment.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.const.KILO_METER
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject


class MapFragment : DaggerFragment(), AnkoLogger, OnMapReadyCallback {

    @Inject
    lateinit var viewModelFactory: MapViewModelFactory
    private lateinit var viewModel: MapViewModel
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables =
        AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)

    private lateinit var mapView: MapView
    private var map: GoogleMap? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        mapView = view.findViewById(R.id.mapMapView)
        mapView.getMapAsync(this)
        mapView.onCreate(savedInstanceState)
        MapLifeCycle(this, mapView)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycle += disposables
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MapViewModel::class.java]
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap
        viewDisposables += viewModel
            .locationObserver
            .subscribe({ location ->
                map?.moveCamera(
                    CameraUpdateFactory.newLatLngZoom(
                        LatLng(
                            location.latitude,
                            location.longitude
                        ), 16.5f
                    )
                )
                viewDisposables += viewModel
                    .getSeller
                    .findByDistance(location.latitude,location.longitude, KILO_METER)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { data ->
                        data.data.forEach{seller ->
                            seller.run {
                                map?.addMarker(
                                    MarkerOptions()
                                        .position(LatLng(latitude,longitude))
                                        .title(sellerName)
                                )
                            }
                        }
                    }
            }, {
                it.printStackTrace()
            })
    }
}
