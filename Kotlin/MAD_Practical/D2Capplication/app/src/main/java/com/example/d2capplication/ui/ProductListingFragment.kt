package com.example.d2capplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.d2capplication.R
import com.example.d2capplication.databinding.FragmentProductListingBinding

class ProductListingFragment : Fragment() {
    private lateinit var binding: FragmentProductListingBinding
    private val nav by lazy { findNavController() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductListingBinding.inflate(inflater, container, false)

        binding.AddBtnL.setOnClickListener { nav.navigate(R.id.addProductFragment) }

        return binding.root
    }
}