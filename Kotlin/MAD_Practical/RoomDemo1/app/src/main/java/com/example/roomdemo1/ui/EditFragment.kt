package com.example.roomdemo1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdemo1.data.Fruit
import com.example.roomdemo1.data.FruitViewModel
import com.example.roomdemo1.databinding.FragmentEditBinding
import com.example.roomdemo1.util.errorDialog

class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding
    private val nav by lazy { findNavController() }
    private val vm: FruitViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)

        reset()
        binding.btnReset.setOnClickListener  { reset() }
        binding.btnSubmit.setOnClickListener { submit() }

        return binding.root
    }

    private fun reset() {
        // TODO: Load data
        val id = arguments?.getInt("id") ?: 0
        vm.get(id).observe(viewLifecycleOwner){ f ->
            if(f == null){
                nav.navigateUp()
                return@observe
            }

            binding.txtId.text = f.id.toString()
            binding.edtName.setText(f.name)
            binding.edtPrice.setText("%.2f".format(f.price))
            binding.edtName.requestFocus()
        }
    }

    private fun submit() {
        // TODO: Update data
        val f = Fruit(
            id = binding.txtId.text.toString().toIntOrNull() ?: 0,
            name = binding.edtName.text.toString().trim(),
            price = binding.edtPrice.text.toString().toDoubleOrNull() ?: 0.0
        )

        // validation
        val err = vm.validate(f)
        if(err != ""){
            errorDialog(err)
            return
        }

        vm.update(f)
        nav.navigateUp()
    }

}