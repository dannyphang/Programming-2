package com.example.navigationdemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.FragmentPage2Binding

class Page2Fragment : Fragment() {

    private lateinit var binding: FragmentPage2Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPage2Binding.inflate(inflater, container, false)

        // TODO: Navigate using action (instead of destination)
        binding.btnBack.setOnClickListener { nav.navigateUp() }
        binding.btnNext.setOnClickListener {
//            nav.navigate(R.id.page3Fragment)
            nav.navigate(R.id.action_page2Fragment_to_page3Fragment)
        }

        return binding.root
    }

}