package com.example.roomdemo2.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo2.R
import com.example.roomdemo2.data.Student

class StudentAdapter (
    // Callback function
    val fn: (ViewHolder, Student) -> Unit = { _, _ -> }
) : ListAdapter<Student, StudentAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(a: Student, b: Student)    = a.id == b.id
        override fun areContentsTheSame(a: Student, b: Student) = a == b
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val root = view
        val txtId     : TextView = view.findViewById(R.id.txtId)
        val txtName   : TextView = view.findViewById(R.id.txtName)
        val txtGender : TextView = view.findViewById(R.id.txtGender)
        val txtProgram: TextView = view.findViewById(R.id.txtProgram)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.txtId.text      = item.id
        holder.txtName.text    = item.name
        holder.txtGender.text  = item.gender
        holder.txtProgram.text = item.programId
        fn(holder, item)
    }

}