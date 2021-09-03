package com.example.roomdemo2.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo2.R
import com.example.roomdemo2.data.StudentCustom

class StudentCustomAdapter (
    // Callback function
    val fn: (ViewHolder, StudentCustom) -> Unit = { _, _ -> }
) : ListAdapter<StudentCustom, StudentCustomAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<StudentCustom>() {
        override fun areItemsTheSame(a: StudentCustom, b: StudentCustom)    = a.id == b.id
        override fun areContentsTheSame(a: StudentCustom, b: StudentCustom) = a == b
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
            .inflate(R.layout.item_student_custom, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        // TODO(14): Complete name, gender, program id and program name
        holder.txtId.text      = item.id
        holder.txtName.text    = item.name
        holder.txtGender.text  = if (item.gender == "F") "Female" else "Male"
        holder.txtProgram.text = "${item.program.id} - ${item.program.name}"
        fn(holder, item)
    }

}