package com.iyeongjoon.nicname.ddalivery.ui.adapters.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

// 메인 뷰페이저 어답터
class MainPagerAdapter(fm : FragmentManager, private val list : List<Fragment>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }
}