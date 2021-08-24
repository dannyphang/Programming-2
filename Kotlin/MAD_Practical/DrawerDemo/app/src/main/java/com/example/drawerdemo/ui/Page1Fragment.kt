package com.example.drawerdemo.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.drawerdemo.R
import com.example.drawerdemo.databinding.FragmentPage1Binding
import com.google.android.material.snackbar.Snackbar

class Page1Fragment : Fragment() {

    private lateinit var binding: FragmentPage1Binding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPage1Binding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.page1, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // NOTE: Why not return true/false? -> No more next level

        when (item.itemId) {
            // Handle navigation manually -> Retain backstack
            R.id.pageAFragment -> nav.navigate(R.id.pageAFragment)
            R.id.pageBFragment -> nav.navigate(R.id.pageBFragment)
            // Custom action
            R.id.custom -> Snackbar.make(binding.root, "Hello from Fragment", Snackbar.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}