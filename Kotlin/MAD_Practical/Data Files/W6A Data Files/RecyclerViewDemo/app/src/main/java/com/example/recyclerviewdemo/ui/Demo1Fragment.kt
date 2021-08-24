package com.example.recyclerviewdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.databinding.FragmentDemo1Binding

class Demo1Fragment : Fragment() {

    private lateinit var binding: FragmentDemo1Binding
    private val nav by lazy { findNavController() }

    // TODO: Shared view model
    private val vm = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDemo1Binding.inflate(inflater, container, false)

        // TODO: Setup RecyclerView
        val adapter = 0

        return binding.root
    }

}