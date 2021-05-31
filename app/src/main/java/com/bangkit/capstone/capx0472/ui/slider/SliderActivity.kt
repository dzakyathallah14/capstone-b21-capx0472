package com.bangkit.capstone.capx0472.ui.slider

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.bangkit.capstone.capx0472.databinding.ActivitySliderBinding

class SliderActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySliderBinding

    private val sectionPagerAdapter = SectionPagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySliderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionPagerAdapter

        val buttons = binding.bottomNavLinearLayout

        for (i in 0 until sectionPagerAdapter.count) {
            val points = TextView(this)
            points.text = "."
            points.setTextColor(Color.parseColor("#FFE4E4E4"))
            points.textSize = 64F

            viewPager.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
                if (i == viewPager.currentItem) {
                    points.setTextColor(Color.parseColor("#FF959595"))
                }else{
                    points.setTextColor(Color.parseColor("#FFE4E4E4"))
                }
            }

            buttons.addView(points)
        }

    }
}