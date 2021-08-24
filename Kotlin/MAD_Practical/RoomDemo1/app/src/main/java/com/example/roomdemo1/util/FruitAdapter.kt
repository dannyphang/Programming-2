package com.example.roomdemo1.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo1.R
import com.example.roomdemo1.data.Fruit

class FruitAdapter (
    // Callback function
    val fn: (ViewHolder, Fruit) -> Unit = { _, _ -> }
) : ListAdapter<Fruit, FruitAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Fruit>() {
        override fun areItemsTheSame(a: Fruit, b: Fruit)    = a.id == b.id
        override fun areContentsTheSame(a: Fruit, b: Fruit) = a == b
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val root = view
        val txtId    : TextView    = view.findViewById(R.id.txtId)
        val txtName  : TextView    = view.findViewById(R.id.txtName)
        val txtPrice : TextView    = view.findViewById(R.id.txtPrice)
        val btnEdit  : ImageButton = view.findViewById(R.id.btnEdit)
        val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.txtId.text    = item.id.toString()
        holder.txtName.text  = item.name
        holder.txtPrice.text = "%.2f".format(item.price)
        fn(holder, item)
    }

}