package com.example.recyclerviewdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Button clicks
        binding.btn1.setOnClickListener { nav.navigate(R.id.demo1Fragment) }
        binding.btn2.setOnClickListener { nav.navigate(R.id.demo2Fragment) }
        binding.btn3.setOnClickListener { nav.navigate(R.id.demo3Fragment) }
        binding.btn4.setOnClickListener { nav.navigate(R.id.demo4Fragment) }

        return binding.root
    }

}