package com.example.firebasedemo2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.firebasedemo2.R
import com.example.firebasedemo2.data.RESTORE_DATA
import com.example.firebasedemo2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnCategory.setOnClickListener { nav.navigate(R.id.categoryFragment)  }
        binding.btnFruit.setOnClickListener { nav.navigate(R.id.fruitFragment) }
        binding.btnRestore.setOnClickListener { RESTORE_DATA() }
        binding.btnDemo1.setOnClickListener { demo1() }
        binding.btnDemo2.setOnClickListener { demo2() }

        return binding.root
    }

    private fun demo1() {
        // TODO(5): Randomize price of all fruits (0.01 to 9.99)

    }

    private fun demo2() {
        // TODO(6): Multiply price of imported fruits by 10

    }

    private fun toast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

}