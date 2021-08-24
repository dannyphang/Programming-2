package com.example.recyclerviewdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.PhotoAdapter
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.SharedViewModel
import com.example.recyclerviewdemo.databinding.FragmentDemo2Binding

class Demo2Fragment : Fragment() {

    private lateinit var binding: FragmentDemo2Binding
    private val nav by lazy { findNavController() }
    private val vm: SharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDemo2Binding.inflate(inflater, container, false)

        // Button clicks
        binding.btnFirst.setOnClickListener    { first() }
        binding.btnLast.setOnClickListener     { last()  }
        binding.btnPrevious.setOnClickListener { prev()  }
        binding.btnNext.setOnClickListener     { next()  }

        // TODO: Setup RecyclerView
        val adapter = PhotoAdapter()
        binding.rv.adapter = adapter
//        binding.rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        vm.photos.observe(viewLifecycleOwner) {
            photo -> adapter.submitList(photo)
            binding.rv.doOnPreDraw { updatePosition() }
        }

        // TODO: SnapHelper
        // to auto center the photo when switching
        val snap = LinearSnapHelper()
        snap.attachToRecyclerView((binding.rv))

        // TODO: ScrollListener
        binding.rv.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(rv: RecyclerView, state: Int) {
                super.onScrollStateChanged(rv, state)
                if (state == RecyclerView.SCROLL_STATE_IDLE) updatePosition()
            }
        })

        return binding.root
    }

    // TODO: Helper functions ----------------------------------------------------------------------

    private fun getCount(): Int {
        return binding.rv.adapter?.itemCount ?: 0
    }

    private fun getPosition(): Int {
        val mgr = binding.rv.layoutManager as LinearLayoutManager
        return mgr.findFirstVisibleItemPosition()
    }

    private fun first() {
        binding.rv.smoothScrollToPosition(0)
    }

    private fun last() {
        binding.rv.smoothScrollToPosition(getCount() - 1)

    }

    private fun prev() {
        val pos = getPosition() - 1
        if (pos >= 0) binding.rv.smoothScrollToPosition(pos)
    }

    private fun next() {
        val pos = getPosition() + 1
        if (pos < getCount()) {
            binding.rv.smoothScrollToPosition(pos)
        }
    }

    private fun updatePosition() {
        val x = getPosition() + 1
        val y = getCount()
        binding.txtPosition.text = "Photo $x of $y"
    }

}