package com.example.recyclerviewdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.recyclerviewdemo.Photo
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.SharedViewModel
import com.example.recyclerviewdemo.databinding.FragmentDemo4Binding

class Demo4Fragment : Fragment() {

    private lateinit var binding: FragmentDemo4Binding
    private val nav by lazy { findNavController() }
    private val vm: SharedViewModel by activityViewModels()

    // TODO: Get argument - id
    private val id by lazy { arguments?.getString("id", "") ?: "" }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDemo4Binding.inflate(inflater, container, false)

        // TODO: Load photo based on id
        val photo = vm.get(id)

        if(photo == null){
            alert("Photo not found.")
            nav.navigateUp()
        }
        else{
            load(photo)
        }

        return binding.root
    }

    private fun alert(text: String) {
        // TODO: Use AlertDialog
       AlertDialog.Builder(requireContext())
           .setIcon(R.drawable.ic_info)
           .setTitle("Error")
           .setMessage(text)
           .setPositiveButton("Dismiss", null)
           .show()
    }

    private fun load(photo: Photo) {
        // TODO: Load photo
        binding.imgPhoto.load(photo.photo) { placeholder(R.drawable.loading_ani) }
        binding.txtId.text     = photo.id
        binding.txtAuthor.text = photo.author
        binding.txtWidth.text  = photo.width.toString()
        binding.txtHeight.text = photo.height.toString()
        binding.txtUrl.text    = photo.url
    }

}