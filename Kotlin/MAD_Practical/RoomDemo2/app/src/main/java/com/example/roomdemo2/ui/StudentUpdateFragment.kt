package com.example.roomdemo2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.roomdemo2.data.Program
import com.example.roomdemo2.data.Student
import com.example.roomdemo2.data.StudentViewModel
import com.example.roomdemo2.databinding.FragmentStudentUpdateBinding
import com.example.roomdemo2.util.errorDialog
import kotlinx.coroutines.launch

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
//        vm.getAllPrograms().observe(viewLifecycleOwner){
//            adapter.addAll(it)
//            reset()
//        }

        // TODO(33): Load spinner and reset
        lifecycleScope.launch {
            adapter.addAll(vm.getPrograms())
            reset()
        }

        binding.btnReset.setOnClickListener  { reset() }
        binding.btnSubmit.setOnClickListener { submit() }
        binding.btnDelete.setOnClickListener { delete() }

        return binding.root
    }

    private fun reset() {
        // TODO(26): Load student
        vm.get(id).observe(viewLifecycleOwner){
            if(it == null){
                nav.navigateUp()
                return@observe
            }
            binding.txtId.text = it.id
            binding.edtName.setText(it.name)
            setGender(it.gender)
            setProgram(it.programId)
            binding.edtName.requestFocus()
        }

    }

    private fun setGender(gender: String) {
        // TODO(27): Check respective radio button
        when (gender){
            "F" -> binding.radFemale.isChecked = true
            "M" -> binding.radMale.isChecked = true
        }

    }

    private fun setProgram(programId: String) {
        // TODO(28): Select respective program
        // 0 is the 1st index
        // binding.spnProgram.count is the last index
        // for example: 0 until 5 = 0, 1, 2, 3, 4
        // 0..5 =  0, 1, 2, 3, 4, 5
        for (i in 0 until binding.spnProgram.count) {
            val p = binding.spnProgram.getItemAtPosition(i) as Program
            if(p.id == programId){
                binding.spnProgram.setSelection(i)
                break
            }
        }

    }

    private fun submit() {
        // TODO(29): Update student + validation
        val s = Student(
            id = id,
            name = binding.edtName.text.toString().trim(),
            gender = if (binding.radFemale.isChecked) "F" else "M",
            programId = (binding.spnProgram.selectedItem as Program).id,
        )
        lifecycleScope.launch {
            val err = vm.validate(s, false)
            if (err != ""){
                errorDialog(err)
                return@launch
            }

            vm.update(s)
            nav.navigateUp()
        }
    }

    private fun delete() {
        // TODO(30): Delete student
        // only provide the 1st parameter but will not fail because the default value of them are ""
        vm.delete(Student(id))

    }

}