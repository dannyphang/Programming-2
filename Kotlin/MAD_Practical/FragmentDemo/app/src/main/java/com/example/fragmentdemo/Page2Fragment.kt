package com.example.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fragmentdemo.databinding.FragmentPage2Binding

class Page2Fragment : Fragment() {

    private lateinit var binding: FragmentPage2Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPage2Binding.inflate(inflater, container, false)

        // TODO
        binding.button.setOnClickListener { nav.navigateUp() }

        return binding.root
    }

}