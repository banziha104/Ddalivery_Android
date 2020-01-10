package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.di.adapters.recyclerview.home.HomeAdapter
import com.iyeongjoon.nicname.ddalivery.di.adapters.recyclerview.home.HomeAdapterViewModel
import com.iyeongjoon.nicname.ddalivery.ex.endScrollEvent
import com.iyeongjoon.nicname.ddalivery.ex.plusAssign
import com.iyeongjoon.nicname.ddalivery.rx.fragment.AutoClearedDisposable
import com.jakewharton.rxbinding3.recyclerview.flingEvents
import com.jakewharton.rxbinding3.recyclerview.scrollEvents
import com.jakewharton.rxbinding3.recyclerview.scrollStateChanges
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class HomeFragment : DaggerFragment(), AnkoLogger {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory
    private lateinit var viewModel: HomeViewModel
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables =
        AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        lifecycle += disposables
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[HomeViewModel::class.java]
        bind()
    }

    private fun bind() {
        disposables += viewModel
            .productObserver
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showProgressBar() }
            .doOnComplete { disapearProgressBar() }
            .subscribe({
                homeRecyclerView.apply {
                    adapter = HomeAdapter(HomeAdapterViewModel(it, context))
                    layoutManager = GridLayoutManager(context, viewModel.gridColumns)
                    endScrollEvent()
                        .subscribe {
                            info { "끝? : $it" }
                        }
//                    scrollEvents().subscribe {
//                        info { "스크롤 / x : ${it.dx} | y : ${it.dy} | view : ${it.view}"  }
//                    }


//                    flingEvents().subscribe {
//                        info { "플링 x : ${it.velocityX} | y : ${it.velocityY} | view : ${it.view}"  }
//                    }

                }
            }, {
                it.printStackTrace()
            })
    }


    private fun showProgressBar() {
        homeProgressBar.visibility = View.VISIBLE
    }

    private fun disapearProgressBar() {
        homeProgressBar.visibility = View.INVISIBLE
    }


}
