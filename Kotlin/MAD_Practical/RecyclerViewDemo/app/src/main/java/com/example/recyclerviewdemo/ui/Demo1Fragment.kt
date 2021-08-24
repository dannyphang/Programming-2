package com.example.recyclerviewdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewdemo.PhotoAdapter
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.SharedViewModel
import com.example.recyclerviewdemo.databinding.FragmentDemo1Binding

class Demo1Fragment : Fragment() {

    private lateinit var binding: FragmentDemo1Binding
    private val nav by lazy { findNavController() }

    // TODO: Shared view model
    private val vm: SharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDemo1Binding.inflate(inflater, container, false)

        // TODO: Setup RecyclerView
        val adapter = PhotoAdapter()
        binding.rv.adapter = adapter

        vm.photos.observe(viewLifecycleOwner) { photo -> adapter.submitList(photo) }

        return binding.root
    }

}