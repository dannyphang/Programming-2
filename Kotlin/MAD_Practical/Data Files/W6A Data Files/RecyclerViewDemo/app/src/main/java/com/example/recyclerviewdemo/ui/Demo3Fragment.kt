package com.example.recyclerviewdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.SharedViewModel
import com.example.recyclerviewdemo.databinding.FragmentDemo3Binding

class Demo3Fragment : Fragment() {

    private lateinit var binding: FragmentDemo3Binding
    private val nav by lazy { findNavController() }
    private val vm: SharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDemo3Binding.inflate(inflater, container, false)

        // TODO: Setup RecyclerView
        val adapter = 0

        return binding.root
    }

    private fun alert(text: String) {
        // TODO: Use AlertDialog
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

}