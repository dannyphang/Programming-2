package com.example.recyclerviewdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.SharedViewModel
import com.example.recyclerviewdemo.databinding.FragmentDemo2Binding

class Demo2Fragment : Fragment() {

    private lateinit var binding: FragmentDemo2Binding
    private val nav by lazy { findNavController() }
    private val vm: SharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDemo2Binding.inflate(inflater, container, false)

        // Button clicks
        binding.btnFirst.setOnClickListener    { first() }
        binding.btnLast.setOnClickListener     { last()  }
        binding.btnPrevious.setOnClickListener { prev()  }
        binding.btnNext.setOnClickListener     { next()  }

        // TODO: Setup RecyclerView
        val adapter = 0

        // TODO: SnapHelper
        val snap = 0

        // TODO: ScrollListener


        return binding.root
    }

    // TODO: Helper functions ----------------------------------------------------------------------

    private fun getCount(): Int {
        return 0
    }

    private fun getPosition(): Int {
        return 0
    }

    private fun first() {

    }

    private fun last() {

    }

    private fun prev() {

    }

    private fun next() {

    }

    private fun updatePosition() {
        val x = 0
        val y = 0
        binding.txtPosition.text = "Photo $x of $y"
    }

}