package com.example.imagedemo.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.imagedemo.data.Image
import com.example.imagedemo.data.ImageViewModel
import com.example.imagedemo.databinding.FragmentUploadBinding
import com.example.imagedemo.util.crop

class UploadFragment : Fragment() {

    private lateinit var binding: FragmentUploadBinding
    private val nav by lazy { findNavController() }
    private val vm: ImageViewModel by activityViewModels()

    // TODO(4): Setup ActivityResultLauncher
    private val launcher = registerForActivityResult(StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            binding.img.setImageURI(it.data?.data)
            binding.btnUpload.visibility = View.VISIBLE
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentUploadBinding.inflate(inflater, container, false)

        binding.btnSelect.setOnClickListener { select() }
        binding.btnUpload.setOnClickListener { upload() }

        return binding.root
    }

    private fun select() {
        // TODO(5): Select image file (using default file picker)
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        launcher.launch(intent)
    }

    @Suppress("DEPRECATION")
    private fun upload() {
        // TODO(6): Save image file + image record
        val bitmap = binding.img.drawable.toBitmap().crop(500, 500)
        val filename = "${System.currentTimeMillis()}.webp"

        requireContext().openFileOutput(filename, Context.MODE_PRIVATE).use {
            bitmap.compress(Bitmap.CompressFormat.WEBP, 80, it)
        }

        vm.insert(Image(name = filename))
        nav.navigateUp()
    }

}