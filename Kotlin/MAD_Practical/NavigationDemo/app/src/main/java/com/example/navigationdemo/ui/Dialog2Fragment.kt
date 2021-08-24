package com.example.navigationdemo.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.FragmentDialog2Binding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// TODO: Convert to BottomSheetDialogFragment
class Dialog2Fragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentDialog2Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDialog2Binding.inflate(inflater, container, false)

        // TODO: Dismiss dialog
        binding.btnDismiss.setOnClickListener { dismiss() }

        return binding.root
    }

}