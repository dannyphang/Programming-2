package com.example.imagedemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.imagedemo.data.Image
import com.example.imagedemo.data.ImageViewModel
import com.example.imagedemo.databinding.FragmentImageBinding

class ImageFragment : Fragment() {

    private lateinit var binding: FragmentImageBinding
    private val nav by lazy { findNavController() }
    private val vm: ImageViewModel by activityViewModels()

    private lateinit var image: Image

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentImageBinding.inflate(inflater, container, false)

        binding.btnDelete.setOnClickListener { delete() }

        // TODO(12): Load image record


        return binding.root
    }

    private fun delete() {
        // TODO(13): Delete image file + image record


    }

}