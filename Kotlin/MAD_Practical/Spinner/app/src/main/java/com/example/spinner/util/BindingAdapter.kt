package com.example.spinner.util

import android.R
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter

@BindingAdapter("items")
fun setItems(view: Spinner, items: List<Any>){
    val adapter = ArrayAdapter(view.context, android.R.layout.simple_spinner_dropdown_item, items)
   view.adapter = adapter
}