package com.example.firebasedemo2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.firebasedemo2.data.Fruit
import com.example.firebasedemo2.data.FruitViewModel
import com.example.firebasedemo2.databinding.FragmentFruitDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.text.DecimalFormat

class FruitDetailFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentFruitDetailBinding
    private val nav by lazy { findNavController() }
    private val vm: FruitViewModel by activityViewModels()

    private val id by lazy { requireArguments().getString("id", "") }
    private val formatter = DecimalFormat("0.00")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentFruitDetailBinding.inflate(inflater, container, false)

        binding.btnClose.setOnClickListener { dismiss() }

        // -----------------------------------------------------------------------------------------

        // TODO(31): Load a specific fruit
        val fruit = vm.get(id)!!

        binding.txtId.text    = fruit.id
        binding.txtName.text  = fruit.name
        binding.txtPrice.text = formatter.format(fruit.price)

        // TODO(32): Display [category.name]
        binding.txtCategory.text = fruit.category.name

        // -----------------------------------------------------------------------------------------

        return binding.root
    }

}