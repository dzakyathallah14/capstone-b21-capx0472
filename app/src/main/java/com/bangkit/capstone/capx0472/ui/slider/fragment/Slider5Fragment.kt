package com.bangkit.capstone.capx0472.ui.slider.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bangkit.capstone.capx0472.databinding.FragmentSlider5Binding
import com.bangkit.capstone.capx0472.ui.MainActivity
import com.bangkit.capstone.capx0472.ui.slider.SliderActivity.Companion.EXTRA_NAME

@Suppress("DEPRECATION")
class Slider5Fragment : Fragment() {

    companion object {
        private const val REQUEST_CODE = 42
    }

    private lateinit var binding: FragmentSlider5Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSlider5Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOk.setOnClickListener{
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (context != null) {
                if (takePictureIntent.resolveActivity(requireContext().packageManager) != null){
                    startActivityForResult(takePictureIntent, REQUEST_CODE)
                } else {
                    Toast.makeText(requireContext(), "Unable to open camera", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val takenImage = data?.extras?.get("data") as Bitmap
            val name = activity?.intent?.getStringExtra(EXTRA_NAME)
            val moveIntent = Intent(context, MainActivity::class.java)
            moveIntent.putExtra(MainActivity.RESULT_PHOTO, takenImage)
            moveIntent.putExtra(MainActivity.RESULT_NAME, name)
            startActivity(moveIntent)
        }else{
            super.onActivityResult(requestCode, resultCode, data)

        }
    }

}