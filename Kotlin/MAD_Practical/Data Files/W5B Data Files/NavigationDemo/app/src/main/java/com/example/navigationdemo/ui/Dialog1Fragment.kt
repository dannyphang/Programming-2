package com.example.navigationdemo.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.FragmentDialog1Binding

// TODO: Convert to DialogFragment
class Dialog1Fragment : Fragment() {

    private lateinit var binding: FragmentDialog1Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDialog1Binding.inflate(inflater, container, false)

        // TODO: Dismiss dialog
        binding.btnDismiss.setOnClickListener {  }

        return binding.root
    }

    // TODO: Adjust dialog size
    override fun onStart() {
        super.onStart()
    }

}