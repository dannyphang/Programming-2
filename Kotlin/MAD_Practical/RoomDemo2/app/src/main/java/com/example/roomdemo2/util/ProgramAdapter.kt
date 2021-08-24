package com.example.roomdemo2.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo2.R
import com.example.roomdemo2.data.Program

class ProgramAdapter (
    // Callback function
    val fn: (ViewHolder, Program) -> Unit = { _, _ -> }
) : ListAdapter<Program, ProgramAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Program>() {
        override fun areItemsTheSame(a: Program, b: Program)    = a.id == b.id
        override fun areContentsTheSame(a: Program, b: Program) = a == b
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val root = view
        val txtId   : TextView = view.findViewById(R.id.txtId)
        val txtName : TextView = view.findViewById(R.id.txtName)
        val txtCount: TextView = view.findViewById(R.id.txtCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_program, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.txtId.text    = item.id
        holder.txtName.text  = item.name
        holder.txtCount.text = "X"
        fn(holder, item)
    }

}