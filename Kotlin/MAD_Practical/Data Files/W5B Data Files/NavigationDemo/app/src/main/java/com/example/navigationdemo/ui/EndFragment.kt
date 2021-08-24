package com.example.navigationdemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.FragmentEndBinding

class EndFragment : Fragment() {

    private lateinit var binding: FragmentEndBinding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentEndBinding.inflate(inflater, container, false)

        // TODO: Navigate using action (instead of destination)
        binding.btnBack.setOnClickListener { nav.navigateUp() }
        binding.btnStart.setOnClickListener {
//            nav.navigate(R.id.startFragment)
            nav.navigate(R.id.action_endFragment_to_startFragment)

        }

        return binding.root
    }

}