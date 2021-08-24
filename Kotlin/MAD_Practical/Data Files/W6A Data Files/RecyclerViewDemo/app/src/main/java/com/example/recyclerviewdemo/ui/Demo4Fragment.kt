package com.example.recyclerviewdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewdemo.Photo
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.SharedViewModel
import com.example.recyclerviewdemo.databinding.FragmentDemo4Binding

class Demo4Fragment : Fragment() {

    private lateinit var binding: FragmentDemo4Binding
    private val nav by lazy { findNavController() }
    private val vm: SharedViewModel by activityViewModels()

    // TODO: Get argument - id
    private val id by lazy { "" }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDemo4Binding.inflate(inflater, container, false)

        // TODO: Load photo based on id
        val photo = 0

        return binding.root
    }

    private fun alert(text: String) {
        // TODO: Use AlertDialog
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    private fun load(photo: Photo) {
        // TODO: Load photo

        binding.txtId.text     = photo.id
        binding.txtAuthor.text = photo.author
        binding.txtWidth.text  = photo.width.toString()
        binding.txtHeight.text = photo.height.toString()
        binding.txtUrl.text    = photo.url
    }

}