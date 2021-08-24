package com.example.navigationdemo.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAboutBinding.inflate(inflater, container, false)

        // TODO: Enable options menu in fragment
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // TODO: Inflate menu about.xml
        inflater.inflate(R.menu.about, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // TODO: Handle navigation for About 1 and About 2
        when (item.itemId) {
            R.id.about1Fragment -> nav.navigate(R.id.about1Fragment)
            R.id.about2Fragment -> nav.navigate(R.id.about2Fragment)
        }

        return super.onOptionsItemSelected(item)
    }
}