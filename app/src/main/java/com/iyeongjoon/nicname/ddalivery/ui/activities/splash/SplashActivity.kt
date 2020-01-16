package com.iyeongjoon.nicname.ddalivery.ui.activities.splash

import android.Manifest
import android.annotation.SuppressLint
import android.icu.util.Calendar
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.auth0.android.jwt.JWT
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.permission.PermissionController
import com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable
import com.iyeongjoon.nicname.core.utils.JWTUtils
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.service.LocationService
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin.SignInActivity
import com.iyeongjoon.nicname.ddalivery.ui.activities.main.MainActivity
import com.iyeongjoon.nicname.domain.domain.db.entity.token.TokenEntity
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startService
import org.w3c.dom.Entity
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(), AnkoLogger , PermissionController.CallBack {
    @Inject
    lateinit var viewModelFactory: SplashViewModelFactory
    private lateinit var viewModel: SplashViewModel
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables =
        AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        permissionCheck()
    }

    private fun bind() {
        startLocationService()
        viewDisposables += Observable.zip(
            viewModel.localDatabase.tokenDao().findAll(),
            viewModel.locationEvent.getLocationObserver(),
            BiFunction<List<TokenEntity>, Location, SplashDataType> { t1, t2 -> SplashDataType(t1, t2) })
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                it.run {
                    if (database.isEmpty()) {
                        startActivity<SignInActivity>()
                    } else {
                        if (JWT(database[0].token).isExpired(0L)) {
                            startActivity<MainActivity>()
                        } else {
                            startActivity<SignInActivity>()
                        }
                    }
                    finish()
                }
            },{
                it.printStackTrace()
            })
    }


    private fun startLocationService() {
        startService<LocationService>()
    }

    override fun init() {
        lifecycle += disposables
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[SplashViewModel::class.java]
        bind()
    }

    data class SplashDataType(val database: List<TokenEntity>, val location: Location)

    private fun permissionCheck() {

        PermissionController(
            this, arrayOf(
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        ).checkVersion()
    }

}
