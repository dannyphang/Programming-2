package com.example.drawerdemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.drawerdemo.R
import com.example.drawerdemo.databinding.FragmentPage3Binding

class Page3Fragment : Fragment() {

    private lateinit var binding: FragmentPage3Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPage3Binding.inflate(inflater, container, false)
        return binding.root
    }

}