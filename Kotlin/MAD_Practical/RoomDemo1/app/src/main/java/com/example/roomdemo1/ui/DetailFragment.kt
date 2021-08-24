package com.example.roomdemo1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdemo1.data.FruitViewModel
import com.example.roomdemo1.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val nav by lazy { findNavController() }
    private val vm: FruitViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        load()
        binding.btnBack.setOnClickListener { nav.navigateUp() }

        return binding.root
    }

    private fun load() {
        // TODO: Load data
        val id = arguments?.getInt("id") ?: 0
        vm.get(id).observe(viewLifecycleOwner){ f ->
            if(f == null){
                nav.navigateUp()
                return@observe
            }

            binding.txtId.text = f.id.toString()
            binding.txtName.text = f.name
            binding.txtPrice.text = "%.2f".format(f.price)
        }

    }

}