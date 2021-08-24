package com.example.recyclerviewdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewdemo.Photo
import com.example.recyclerviewdemo.PhotoAdapter
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.SharedViewModel
import com.example.recyclerviewdemo.databinding.FragmentDemo3Binding

class Demo3Fragment : Fragment() {

    private lateinit var binding: FragmentDemo3Binding
    private val nav by lazy { findNavController() }
    private val vm: SharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDemo3Binding.inflate(inflater, container, false)

        // TODO: Setup RecyclerView
        val adapter = PhotoAdapter() { holder, photo ->
            // Entire item
            holder.root.setOnClickListener{
                nav.navigate(R.id.demo4Fragment, bundleOf("id" to photo.id))
            }
            // TextView
            holder.txtAuthor.setOnClickListener {
                alert(photo)
            }
        }
        binding.rv.adapter = adapter

        vm.photos.observe(viewLifecycleOwner) { photo -> adapter.submitList(photo) }

        return binding.root
    }

    private fun alert(photo: Photo) {
        val msg = """
            Id : ${photo.id}
            Author : ${photo.author}
            Width : ${photo.width}
            Height : ${photo.height}
        """.trimIndent()

        // TODO: Use AlertDialog
        AlertDialog.Builder(requireContext())
            .setIcon(R.drawable.ic_info)
            .setTitle("Information")
            .setMessage(msg)
            .setPositiveButton("Dismiss", null)
            .show()
    }

}