package com.example.firebasedemo2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.firebasedemo2.data.CategoryViewModel
import com.example.firebasedemo2.databinding.FragmentCategoryDetailBinding
import com.example.firebasedemo2.util.FruitAdapter

class CategoryDetailFragment : Fragment() {

    private lateinit var binding: FragmentCategoryDetailBinding
    private val nav by lazy { findNavController() }
    private val vm: CategoryViewModel by activityViewModels()

    private val id by lazy { requireArguments().getString("id") ?: "" }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)

        // -----------------------------------------------------------------------------------------

        val adapter = FruitAdapter()
        binding.rv.adapter = adapter
        binding.rv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        // -----------------------------------------------------------------------------------------

        // TODO(12): Load a specific category -> launch block
        //           Load all fruits under a specific category


        // -----------------------------------------------------------------------------------------

        return binding.root
    }

}