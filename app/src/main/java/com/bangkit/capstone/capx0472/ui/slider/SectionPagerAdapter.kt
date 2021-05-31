package com.bangkit.capstone.capx0472.ui.slider

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bangkit.capstone.capx0472.ui.slider.fragment.*
import java.lang.IllegalStateException

@Suppress("DEPRECATION")
class SectionPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Slider1Fragment()
            1 -> Slider2Fragment()
            2 -> Slider3Fragment()
            3 -> Slider4Fragment()
            4 -> Slider5Fragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}