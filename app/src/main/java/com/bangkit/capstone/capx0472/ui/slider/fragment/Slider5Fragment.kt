package com.bangkit.capstone.capx0472.ui.slider.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit.capstone.capx0472.MainActivity
import com.bangkit.capstone.capx0472.R
import com.bangkit.capstone.capx0472.databinding.FragmentSlider5Binding
import com.bangkit.capstone.capx0472.ui.slider.SliderActivity

class Slider5Fragment : Fragment() {

    private lateinit var binding: FragmentSlider5Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSlider5Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOk.setOnClickListener{
            val moveIntent = Intent(context, MainActivity::class.java)
            startActivity(moveIntent)
        }
    }

}