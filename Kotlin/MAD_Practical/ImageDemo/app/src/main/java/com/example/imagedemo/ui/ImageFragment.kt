package com.example.imagedemo.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.imagedemo.data.Image
import com.example.imagedemo.data.ImageViewModel
import com.example.imagedemo.databinding.FragmentImageBinding
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter

class ImageFragment : Fragment() {

    private lateinit var binding: FragmentImageBinding
    private val nav by lazy { findNavController() }
    private val vm: ImageViewModel by activityViewModels()

    private lateinit var image: Image

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentImageBinding.inflate(inflater, container, false)

        binding.btnDelete.setOnClickListener { delete() }

        // TODO(12): Load image record
        lifecycleScope.launch {
            val id = requireArguments().getInt("id")
            image = vm.get(id)

            val baseUri = requireContext().filesDir.toUri()
            val uri = Uri.withAppendedPath(baseUri, image.name)
            binding.img.setImageURI(uri)

            binding.txtId.text = image.id.toString()
            binding.txtName.text = image.name

            val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy 'at' hh:mm:ss a")
            binding.txtDate.text = image.date.format(formatter)
        }

        return binding.root
    }

    private fun delete() {
        // TODO(13): Delete image file + image record
        requireContext().deleteFile(image.name)
        vm.delete(image)
        nav.navigateUp()
    }

}