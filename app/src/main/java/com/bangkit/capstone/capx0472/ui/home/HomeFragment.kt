package com.bangkit.capstone.capx0472.ui.home

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bangkit.capstone.capx0472.R
import com.bangkit.capstone.capx0472.databinding.FragmentHomeBinding
import com.bangkit.capstone.capx0472.ui.MainActivity.Companion.RESULT_NAME
import com.bangkit.capstone.capx0472.ui.MainActivity.Companion.RESULT_PHOTO
import com.bumptech.glide.Glide

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val name = activity?.intent?.getStringExtra(RESULT_NAME)
        val photo = activity?.intent?.getParcelableExtra<Bitmap>(RESULT_PHOTO)

        binding.progressBar.visibility = View.VISIBLE
        if (name != null){
            if (activity != null){
                Glide.with(requireActivity())
                    .load(R.drawable.ok_icon)
                    .into(binding.imgResult)
                binding.tvResult.text = resources.getString(R.string.result_ok)
            }
        } else {
            if (activity != null){
                Glide.with(requireActivity())
                    .load(R.drawable.bad_icon)
                    .into(binding.imgResult)
                binding.tvResult.text = resources.getString(R.string.result_bad)
            }
        }

        binding.tvWelcome.text = resources.getString(R.string.welcome_name, name)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}