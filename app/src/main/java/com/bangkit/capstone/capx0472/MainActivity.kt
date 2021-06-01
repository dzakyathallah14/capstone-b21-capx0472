package com.bangkit.capstone.capx0472

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.capstone.capx0472.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val RESULT_PHOTO = "result_photo"
        const val RESULT_NAME = "result_name"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(RESULT_NAME)
        val photo = intent.getParcelableExtra<Bitmap>(RESULT_PHOTO)

        binding.tvName.text = name
        binding.imgPhoto.setImageBitmap(photo)

    }
}