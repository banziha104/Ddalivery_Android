package com.iyeongjoon.nicname.ddalivery.ui.activities.main

import android.Manifest
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.permission.PermissionController
import com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.service.LocationService
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startService
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), AnkoLogger, PermissionController.CallBack {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables =
        AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissionCheck()
        lifecycle += disposables
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        bindViewPager()
    }

    private fun bindViewPager() {
        mainViewPager.adapter = viewModel.getMainAdapter(supportFragmentManager)
        viewModel.tabTitles.forEach { mainTabLayout.addTab(mainTabLayout.newTab().setText(it)) }
        mainViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mainTabLayout))
        mainTabLayout.addOnTabSelectedListener(
            TabLayout.ViewPagerOnTabSelectedListener(
                mainViewPager
            )
        )
        mainTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
//                val tabIconColor = ContextCompat.getColor(this@MainActivity, R.color.icon_selected)
//                tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
//                val tabIconColor = ContextCompat.getColor(this@MainActivity, R.color.icon_unselected)
//                tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    fun permissionCheck() {
        PermissionController(
            this, arrayOf(
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        ).checkVersion()
    }

    override fun init() {
        startService<LocationService>()
    }
}
