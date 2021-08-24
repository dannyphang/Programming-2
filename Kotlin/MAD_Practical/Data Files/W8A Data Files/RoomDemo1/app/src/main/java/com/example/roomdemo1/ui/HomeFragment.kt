package com.example.roomdemo1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdemo1.R
import com.example.roomdemo1.data.FruitViewModel
import com.example.roomdemo1.databinding.FragmentHomeBinding
import com.example.roomdemo1.util.FruitAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val nav by lazy { findNavController() }
    private val vm: FruitViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // RecyclerView
        val adapter = FruitAdapter() { holder, f ->
            holder.root.setOnClickListener      { nav.navigate(R.id.detailFragment, /* TODO */) }
            holder.btnEdit.setOnClickListener   { nav.navigate(R.id.editFragment,   /* TODO */) }
            holder.btnDelete.setOnClickListener { /* TODO */ }
        }

        binding.rv.adapter = adapter

        // TODO: Fill RecyclerView with data


        // TODO: Add RecyclerView divider


        // Buttons
        binding.btnDeleteAll.setOnClickListener { /* TODO */ }
        binding.fabAdd.setOnClickListener { nav.navigate(R.id.addFragment) }

        return binding.root
    }

}