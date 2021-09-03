package com.example.roomdemo2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.roomdemo2.data.ProgramViewModel
import com.example.roomdemo2.databinding.FragmentProgramDetailBinding
import com.example.roomdemo2.util.StudentAdapter

class ProgramDetailFragment : Fragment() {

    private lateinit var binding: FragmentProgramDetailBinding
    private val nav by lazy { findNavController() }
    private val vm: ProgramViewModel by activityViewModels()

    private val id by lazy { arguments?.getString("id") ?: "" }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentProgramDetailBinding.inflate(inflater, container, false)

        // TODO(7): Display program id and name
        vm.get(id).observe(viewLifecycleOwner){
            if(it == null){ // it = program
                nav.navigateUp()
                return@observe
            }

            binding.txtId.text = it.id
            binding.txtName.text = it.name
        }

        val adapter = StudentAdapter()
        binding.rv.adapter = adapter
        binding.rv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        // TODO(10): Display students -> RecyclerView
        vm.getStudentByProgramId(id).observe(viewLifecycleOwner){
            adapter.submitList(it)
            binding.txtCount.text = "${it.size} record(s)"
        }

        return binding.root
    }

}