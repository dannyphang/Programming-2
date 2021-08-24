package com.example.navigationdemo.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.FragmentDialog2Binding

// TODO: Convert to BottomSheetDialogFragment
class Dialog2Fragment : Fragment() {

    private lateinit var binding: FragmentDialog2Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDialog2Binding.inflate(inflater, container, false)

        // TODO: Dismiss dialog
        binding.btnDismiss.setOnClickListener {  }

        return binding.root
    }

}