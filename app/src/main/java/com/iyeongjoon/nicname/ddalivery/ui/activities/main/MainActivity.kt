package com.iyeongjoon.nicname.ddalivery.ui.activities.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ui.activities.cart.CartActivity
import com.jakewharton.rxbinding3.view.clicks
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), AnkoLogger{

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables = AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle += disposables
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        bindViewPager()
        bind()
    }

    private fun bind(){
        viewDisposables += mainBtnCart
            .clicks()
            .subscribe { startActivity<CartActivity>() }
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

}
