package com.example.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fragmentdemo.databinding.FragmentPage1Binding

class Page1Fragment : Fragment() {

    private lateinit var binding: FragmentPage1Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPage1Binding.inflate(inflater, container, false)

        binding.button.setOnClickListener { nav.navigate(R.id.page2Fragment) }

        return binding.root
    }

}