package com.example.firebasedemo2.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasedemo2.R
import com.example.firebasedemo2.data.Category

class CategoryAdapter (
    val fn: (ViewHolder, Category) -> Unit = { _, _ -> }
) : ListAdapter<Category, CategoryAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(a: Category, b: Category)    = a.id == b.id
        override fun areContentsTheSame(a: Category, b: Category) = a == b
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
            .inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = getItem(position)

        holder.txtId.text    = category.id
        holder.txtName.text  = category.name

        // TODO(9): Display [count] field
        holder.txtCount.text = "${category.count} Fruit(s)"

        fn(holder, category)
    }

}