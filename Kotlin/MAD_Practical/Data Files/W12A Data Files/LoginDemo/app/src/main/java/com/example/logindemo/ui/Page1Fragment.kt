package com.example.logindemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.logindemo.data.AuthViewModel
import com.example.logindemo.databinding.FragmentPage1Binding
import com.example.logindemo.util.informationDialog

class Page1Fragment : Fragment() {

    private lateinit var binding: FragmentPage1Binding
    private val nav by lazy { findNavController() }
    private val auth: AuthViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPage1Binding.inflate(inflater, container, false)
        binding.btnSecret.setOnClickListener { secret() }

        // TODO(9): Hide button if not login


        return binding.root
    }

    private fun secret() {
        val user = auth.getUser()
        informationDialog("Hello, ${user?.name}.")
    }

}