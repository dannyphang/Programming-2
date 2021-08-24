package com.example.drawerdemo.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.drawerdemo.R
import com.example.drawerdemo.databinding.FragmentPageBBinding

class PageBFragment : Fragment() {

    private lateinit var binding: FragmentPageBBinding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPageBBinding.inflate(inflater, container, false)
        return binding.root
    }

}