package com.example.firebasedemo2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.firebasedemo2.R
import com.example.firebasedemo2.data.Category
import com.example.firebasedemo2.data.FruitViewModel
import com.example.firebasedemo2.databinding.FragmentFruitBinding
import com.example.firebasedemo2.util.FruitAdapter
import kotlinx.coroutines.launch

class FruitFragment : Fragment() {

    private lateinit var binding: FragmentFruitBinding
    private val nav by lazy { findNavController() }
    private val vm: FruitViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentFruitBinding.inflate(inflater, container, false)

        // -----------------------------------------------------------------------------------------

        // TODO(29): Default search, filter and sort
        vm.search("")
        vm.filter("")
        sort("id")

        // -----------------------------------------------------------------------------------------

        val adapter = FruitAdapter() { holder, fruit ->
            holder.root.setOnClickListener {
                nav.navigate(R.id.fruitDetailFragment, bundleOf("id" to fruit.id))
            }
        }
        binding.rv.adapter = adapter
        binding.rv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        // TODO(16): Load fruits data into recycler view
        vm.getResult().observe(viewLifecycleOwner){ fruits ->
            adapter.submitList(fruits)
            binding.txtCount.text = "${fruits.size} Record(s)"
        }

        // -----------------------------------------------------------------------------------------

        val arrayAdapter = ArrayAdapter<Category>(requireContext(), android.R.layout.simple_spinner_item)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spn.adapter = arrayAdapter

        // TODO(18): Load categories data into spinner -> launch block
        lifecycleScope.launch {
            val cat = vm.getCategories()
            arrayAdapter.add(Category("", "All"))
            arrayAdapter.addAll(cat)
        }

        // -----------------------------------------------------------------------------------------

        binding.sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(name: String) = true
            override fun onQueryTextChange(name: String): Boolean {
                // TODO(19): Search by [name] -> vm.search(...)
                vm.search(name)
                return true
            }
        })

        // -----------------------------------------------------------------------------------------

        binding.spn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // TODO(20): Filter by [categoryId] -> vm.filter(...)
                val cat = arrayAdapter.getItem(position)!!
                vm.filter(cat.id)
            }
        }

        // -----------------------------------------------------------------------------------------

        binding.btnId.setOnClickListener { sort("id") }
        binding.btnName.setOnClickListener { sort("name") }
        binding.btnPrice.setOnClickListener { sort("price") }

        // -----------------------------------------------------------------------------------------

        return binding.root
    }

    private fun sort(field: String) {
        // TODO(26): Sort by [field] -> vm.sort(...)
        val reverse = vm.sort(field)

        // TODO(27): Remove icon -> all buttons
        binding.btnId.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
        binding.btnName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
        binding.btnPrice.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)

        // TODO(28): Set icon -> specific button
        val res = if (reverse) {
            R.drawable.ic_down
        }
        else{
            R.drawable.ic_up
        }

        when (field) {
            "id" -> binding.btnId.setCompoundDrawablesWithIntrinsicBounds(0, 0, res, 0)
            "name" -> binding.btnName.setCompoundDrawablesWithIntrinsicBounds(0, 0, res, 0)
            "price" -> binding.btnPrice.setCompoundDrawablesWithIntrinsicBounds(0, 0, res, 0)
        }
    }

}