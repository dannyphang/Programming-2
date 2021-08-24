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
import com.example.roomdemo2.data.ProgramViewModel
import com.example.roomdemo2.databinding.FragmentProgramBinding
import com.example.roomdemo2.util.ProgramAdapter

class ProgramFragment : Fragment() {

    private lateinit var binding: FragmentProgramBinding
    private val nav by lazy { findNavController() }
    private val vm: ProgramViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentProgramBinding.inflate(inflater, container, false)

        // TODO(5): Use -> ProgramCustomAdapter
        val adapter = ProgramAdapter() { holder, p ->
            holder.root.setOnClickListener { nav.navigate(R.id.programDetailFragment, bundleOf("id" to p.id)) }
        }
        binding.rv.adapter = adapter
        binding.rv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        // TODO(6): Use -> getAllCustom
        vm.getAll().observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.txtCount.text = "${it.size} record(s)"
        }

        return binding.root
    }

}