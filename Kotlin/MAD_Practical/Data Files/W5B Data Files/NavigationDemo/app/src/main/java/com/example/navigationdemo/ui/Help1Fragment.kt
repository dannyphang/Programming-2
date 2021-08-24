package com.example.navigationdemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.FragmentHelp1Binding

class Help1Fragment : Fragment() {

    private lateinit var binding: FragmentHelp1Binding
    private val nav by lazy { findNavController() }

    // TODO: Obtain values from arguments
    private val time = "N/A"
    private val number = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHelp1Binding.inflate(inflater, container, false)

        binding.btnBack.setOnClickListener { nav.navigateUp() }
        binding.txtTime.text = time
        binding.txtNumber.text = number.toString()

        return binding.root
    }

}