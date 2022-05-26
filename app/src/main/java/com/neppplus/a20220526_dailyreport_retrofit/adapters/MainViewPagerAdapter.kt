package com.neppplus.a20220526_dailyreport_retrofit.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.neppplus.a20220526_dailyreport_retrofit.fragments.*

class MainViewPagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FeedFragment()
            0 -> StatFragment()
            0 -> HomeFragment()
            0 -> TimeTableFragment()
            else -> SettingFragment()
        }
    }
}