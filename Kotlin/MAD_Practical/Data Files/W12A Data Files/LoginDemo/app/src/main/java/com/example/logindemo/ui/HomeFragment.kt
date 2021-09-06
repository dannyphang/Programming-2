package com.example.logindemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.logindemo.data.RESTORE_USERS
import com.example.logindemo.databinding.FragmentHomeBinding
import com.example.logindemo.util.snackbar

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.btnRestore.setOnClickListener { restore() }
        return binding.root
    }

    private fun restore() {
        val ctx = requireContext()
        RESTORE_USERS(ctx)
        snackbar("Users restored.")
    }

}