package com.example.roomdemo2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdemo2.data.Program
import com.example.roomdemo2.data.StudentViewModel
import com.example.roomdemo2.databinding.FragmentStudentInsertBinding

class StudentInsertFragment : Fragment() {

    private lateinit var binding: FragmentStudentInsertBinding
    private val nav by lazy { findNavController() }
    private val vm: StudentViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentStudentInsertBinding.inflate(inflater, container, false)

        val adapter = ArrayAdapter<Program>(requireContext(), android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnProgram.adapter = adapter

        // TODO(21): Load spinner with programs


        reset()
        binding.btnReset.setOnClickListener  { reset() }
        binding.btnSubmit.setOnClickListener { submit() }

        return binding.root
    }

    private fun reset() {
        binding.edtId.text.clear()
        binding.edtName.text.clear()
        binding.radFemale.isChecked = true
        binding.spnProgram.setSelection(0)
        binding.edtId.requestFocus()
    }

    private fun submit() {
        // TODO(22): Insert student + validation


    }

}