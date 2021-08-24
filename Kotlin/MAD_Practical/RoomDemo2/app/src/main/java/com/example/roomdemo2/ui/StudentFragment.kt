package com.example.roomdemo2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.roomdemo2.R
import com.example.roomdemo2.data.StudentViewModel
import com.example.roomdemo2.databinding.FragmentStudentBinding
import com.example.roomdemo2.util.StudentAdapter

class StudentFragment : Fragment() {

    private lateinit var binding: FragmentStudentBinding
    private val nav by lazy { findNavController() }
    private val vm: StudentViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentStudentBinding.inflate(inflater, container, false)

        binding.btnInsert.setOnClickListener { nav.navigate(R.id.studentInsertFragment) }

        // TODO(15): Use -> StudentCustomAdapter
        val adapter = StudentAdapter() { holder, s ->
            holder.root.setOnClickListener { nav.navigate(R.id.studentUpdateFragment, bundleOf("id" to s.id)) }
        }
        binding.rv.adapter = adapter
        binding.rv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        // TODO(16): Use -> getAllCustom
        // TODO(19): Use -> search result
        vm.getAll().observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.txtCount.text = "${it.size} record(s)"
        }

        // TODO(20): SearchView -> OnQueryTextListener


        return binding.root
    }

}