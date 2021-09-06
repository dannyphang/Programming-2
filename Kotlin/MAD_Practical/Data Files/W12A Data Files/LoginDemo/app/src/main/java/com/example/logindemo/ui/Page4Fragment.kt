package com.example.logindemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.logindemo.databinding.FragmentPage4Binding

class Page4Fragment : Fragment() {

    private lateinit var binding: FragmentPage4Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPage4Binding.inflate(inflater, container, false)
        return binding.root
    }

}