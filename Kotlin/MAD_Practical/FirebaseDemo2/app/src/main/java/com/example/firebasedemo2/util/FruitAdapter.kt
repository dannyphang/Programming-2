package com.example.firebasedemo2.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasedemo2.R
import com.example.firebasedemo2.data.Fruit
import java.text.DecimalFormat

class FruitAdapter (
    val fn: (ViewHolder, Fruit) -> Unit = { _, _ -> }
) : ListAdapter<Fruit, FruitAdapter.ViewHolder>(DiffCallback) {

    private val formatter = DecimalFormat("0.00")

    companion object DiffCallback : DiffUtil.ItemCallback<Fruit>() {
        override fun areItemsTheSame(a: Fruit, b: Fruit)    = a.id == b.id
        override fun areContentsTheSame(a: Fruit, b: Fruit) = a == b
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val root = view
        val txtId      : TextView = view.findViewById(R.id.txtId)
        val txtName    : TextView = view.findViewById(R.id.txtName)
        val txtCategory: TextView = view.findViewById(R.id.txtCategory)
        val txtPrice   : TextView = view.findViewById(R.id.txtPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_fruit, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = getItem(position)

        holder.txtId.text    = fruit.id
        holder.txtName.text  = fruit.name
        holder.txtPrice.text = formatter.format(fruit.price)

        // TODO(13): Display [category.name]
        holder.txtCategory.text = fruit.category.name

        fn(holder, fruit)
    }

}