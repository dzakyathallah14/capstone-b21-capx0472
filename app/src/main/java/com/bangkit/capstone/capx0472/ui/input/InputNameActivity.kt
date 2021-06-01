package com.bangkit.capstone.capx0472.ui.input

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.capstone.capx0472.R
import com.bangkit.capstone.capx0472.databinding.ActivityInputNameBinding
import com.bangkit.capstone.capx0472.ui.slider.SliderActivity
import com.bumptech.glide.Glide

class InputNameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = ""

        Glide.with(this)
            .load(R.drawable.bannercapstone)
            .into(binding.imgBanner)

        binding.btnOk.setOnClickListener{
            val name = binding.edtName.text.toString().trim()

            if (name.isEmpty()){
                binding.edtName.error = "Field can not be blank"
            }else {
                val moveIntent = Intent(this, SliderActivity::class.java)
                moveIntent.putExtra(SliderActivity.EXTRA_NAME, name)
                startActivity(moveIntent)
            }

        }
    }
}