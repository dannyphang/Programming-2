package com.example.imagedemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.imagedemo.data.ImageViewModel
import com.example.imagedemo.databinding.FragmentUploadBinding

class UploadFragment : Fragment() {

    private lateinit var binding: FragmentUploadBinding
    private val nav by lazy { findNavController() }
    private val vm: ImageViewModel by activityViewModels()

    // TODO(4): Setup ActivityResultLauncher


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentUploadBinding.inflate(inflater, container, false)

        binding.btnSelect.setOnClickListener { select() }
        binding.btnUpload.setOnClickListener { upload() }

        return binding.root
    }

    private fun select() {
        // TODO(5): Select image file (using default file picker)


    }

    private fun upload() {
        // TODO(6): Save image file + image record


    }

}