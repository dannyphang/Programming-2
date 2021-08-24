package com.example.navigationdemo.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.FragmentAbout1Binding

class About1Fragment : Fragment() {

    private lateinit var binding: FragmentAbout1Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAbout1Binding.inflate(inflater, container, false)

        // TODO: Enable options menu in fragment
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // TODO: Clear menu
        menu.clear()

        super.onCreateOptionsMenu(menu, inflater)
    }
}