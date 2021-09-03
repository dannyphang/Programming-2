package com.example.roomdemo2.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo2.R
import com.example.roomdemo2.data.ProgramCustom

class ProgramCustomAdapter (
    // Callback function
    val fn: (ViewHolder, ProgramCustom) -> Unit = { _, _ -> }
) : ListAdapter<ProgramCustom, ProgramCustomAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<ProgramCustom>() {
        override fun areItemsTheSame(a: ProgramCustom, b: ProgramCustom)    = a.id == b.id
        override fun areContentsTheSame(a: ProgramCustom, b: ProgramCustom) = a == b
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
        // TODO(4): Complete name and count
        holder.txtId.text    = item.id
        holder.txtName.text  = item.name
        holder.txtCount.text = item.students.size.toString()
        fn(holder, item)
    }

}