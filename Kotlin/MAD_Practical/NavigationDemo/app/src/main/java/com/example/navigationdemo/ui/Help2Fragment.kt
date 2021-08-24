package com.example.navigationdemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.FragmentHelp2Binding

class Help2Fragment : Fragment() {

    private lateinit var binding: FragmentHelp2Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHelp2Binding.inflate(inflater, container, false)

        binding.btnBack.setOnClickListener { nav.navigateUp() }
        binding.btnDialog1.setOnClickListener { nav.navigate(R.id.dialog1Fragment) }
        binding.btnDialog2.setOnClickListener { nav.navigate(R.id.dialog2Fragment) }

        return binding.root
    }

}