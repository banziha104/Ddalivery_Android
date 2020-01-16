package com.iyeongjoon.nicname.ddalivery.ui.activities.main

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.ddalivery.ui.adapters.viewpager.MainPagerAdapter
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.category.CategoryFragment
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home.HomeFragment
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.map.MapFragment
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.search.SearchFragment
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.user.UserFragment

class MainViewModel : ViewModel(){
//    val adapter = MainPagerAdapter(supportFragmentManager, list)
    val fragments = listOf(HomeFragment(),CategoryFragment(),MapFragment(),SearchFragment(),UserFragment())
    val tabTitles = listOf("홈","카테고리","지도","검색","내 페이지")

    fun getMainAdapter(fm : FragmentManager) = MainPagerAdapter(fm,fragments)
}