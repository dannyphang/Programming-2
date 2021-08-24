package com.example.roomdemo1.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdemo1.R
import com.example.roomdemo1.data.FruitViewModel
import com.example.roomdemo1.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val nav by lazy { findNavController() }
    private val vm: FruitViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        reset()
        binding.btnReset.setOnClickListener  { reset() }
        binding.btnSubmit.setOnClickListener { submit() }

        return binding.root
    }

    private fun reset() {
        binding.edtName.text.clear()
        binding.edtPrice.text.clear()
        binding.edtName.requestFocus()
    }

    private fun submit() {
        // TODO: Insert data

    }

    // TODO: Convert to extension method
    private fun error(text: String) {
        AlertDialog.Builder(context)
            .setIcon(R.drawable.ic_error)
            .setTitle("Error")
            .setMessage(text)
            .setPositiveButton("Dismiss", null)
            .show()
    }

}