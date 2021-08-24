package com.example.navigationdemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {

    private lateinit var binding: FragmentHelpBinding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHelpBinding.inflate(inflater, container, false)

        binding.btnHelp1.setOnClickListener {
            // TODO: Pass arguments to destination (time and number)

            nav.navigate(R.id.help1Fragment)
        }

        binding.btnHelp2.setOnClickListener { nav.navigate(R.id.help2Fragment) }

        return binding.root
    }

}