package com.example.newsapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.idn.newsapp.UI.AboutAlQuranFragment
import com.idn.newsapp.UI.CommonFragment
import com.idn.newsapp.UI.WarningFragment
import com.idn.newsapp.UI.aljazeera

class SectionPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CommonFragment()
            1 -> AboutAlQuranFragment()
            2 -> aljazeera()
            3 -> WarningFragment()
            else -> aljazeera()
        }
    }
}