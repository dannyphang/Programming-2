package com.example.imagedemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.imagedemo.R
import com.example.imagedemo.data.ImageViewModel
import com.example.imagedemo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val nav by lazy { findNavController() }
    private val vm: ImageViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnDeleteAll.setOnClickListener { deleteAll() }
        binding.fab.setOnClickListener { nav.navigate(R.id.uploadFragment) }

        // TODO(9): Setup RecyclerView


        // TODO(10): Setup dataset for RecyclerView


        return binding.root
    }

    private fun deleteAll() {
        // TODO(11): Delete all image files + image records


    }

}