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
import com.example.roomdemo2.databinding.FragmentStudentUpdateBinding

class StudentUpdateFragment : Fragment() {

    private lateinit var binding: FragmentStudentUpdateBinding
    private val nav by lazy { findNavController() }
    private val vm: StudentViewModel by activityViewModels()

    private val id by lazy { arguments?.getString("id") ?: "" }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentStudentUpdateBinding.inflate(inflater, container, false)

        val adapter = ArrayAdapter<Program>(requireContext(), android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnProgram.adapter = adapter

        // TODO(25): Load spinner with programs


        reset()
        binding.btnReset.setOnClickListener  { reset() }
        binding.btnSubmit.setOnClickListener { submit() }
        binding.btnDelete.setOnClickListener { delete() }

        return binding.root
    }

    private fun reset() {
        // TODO(26): Load student


    }

    private fun setGender(gender: String) {
        // TODO(27): Check respective radio button


    }

    private fun setProgram(programId: String) {
        // TODO(28): Select respective program


    }

    private fun submit() {
        // TODO(29): Update student + validation


    }

    private fun delete() {
        // TODO(30): Delete student


    }

}