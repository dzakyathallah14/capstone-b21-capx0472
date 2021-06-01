package com.bangkit.capstone.capx0472.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.capstone.capx0472.R
import com.bangkit.capstone.capx0472.databinding.ActivityAboutBinding
import com.bumptech.glide.Glide

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "About"

        Glide.with(this)
            .load(R.drawable.bannercapstone)
            .into(binding.imgBanner)
    }
}