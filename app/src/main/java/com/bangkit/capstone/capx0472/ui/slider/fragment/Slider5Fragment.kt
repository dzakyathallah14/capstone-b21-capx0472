package com.bangkit.capstone.capx0472.ui.slider.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.bangkit.capstone.capx0472.databinding.FragmentSlider5Binding
import com.bangkit.capstone.capx0472.ui.MainActivity
import com.bangkit.capstone.capx0472.ui.slider.SliderActivity.Companion.EXTRA_NAME
import com.bangkit.capstone.capx0472.ui.slider.SliderActivity.Companion.EXTRA_NIK
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File


@Suppress("DEPRECATION")
class Slider5Fragment : Fragment() {

    companion object {
        private const val REQUEST_CODE = 42
        private const val FILE_NAME = "photo.jpg"
    }

    private lateinit var binding: FragmentSlider5Binding
    private lateinit var photoFile: File
    private lateinit var fileProvider: Uri
    private lateinit var storageReference: StorageReference

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

        storageReference = FirebaseStorage.getInstance().reference

        binding.btnOk.setOnClickListener{
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            photoFile = getPhotoFile(FILE_NAME)

            if (context != null) {
                fileProvider = FileProvider.getUriForFile(requireContext(), "com.bangkit.capstone.capx0472.fileprovider", photoFile)
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)
                if (takePictureIntent.resolveActivity(requireContext().packageManager) != null){
                    startActivityForResult(takePictureIntent, REQUEST_CODE)
                } else {
                    Toast.makeText(requireContext(), "Unable to open camera", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun getPhotoFile(fileName: String): File {
        val storageDirectory = context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDirectory)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val takenImage = BitmapFactory.decodeFile(photoFile.absolutePath)
            val name = activity?.intent?.getStringExtra(EXTRA_NAME)
            val nik = activity?.intent?.getStringExtra(EXTRA_NIK)
            val join = "$name $nik"
            val moveIntent = Intent(context, MainActivity::class.java)
      //      moveIntent.putExtra(MainActivity.RESULT_PHOTO, takenImage)
            if (name != null) {
                uploadImageToFirebase(join, fileProvider)
            }
            moveIntent.putExtra(MainActivity.RESULT_NAME, name)
            startActivity(moveIntent)
        }else{
            super.onActivityResult(requestCode, resultCode, data)

        }
    }

    private fun uploadImageToFirebase(name: String, contentUri: Uri) {
        val image = storageReference.child("test_pictures-1/$name")
        image.putFile(contentUri).addOnSuccessListener {
            image.downloadUrl.addOnSuccessListener { uri ->
                Log.d(
                    "tag",
                    "onSuccess: Uploaded Image URl is $uri"
                )
            }
            Toast.makeText(context, "Image Is Uploaded.", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(
                context,
                "Upload Failled.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}