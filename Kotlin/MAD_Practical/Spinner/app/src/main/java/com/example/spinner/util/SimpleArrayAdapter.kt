package com.example.spinner.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes

class SimpleArrayAdapter<T>(
    private val ctx: Context,
    @LayoutRes private val res: Int,
    private val obj: List<T>,
    private val fn: (View, T, Int, SimpleArrayAdapter<T>) -> Unit

    ):ArrayAdapter<T>(ctx, res, obj) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(ctx).inflate(res, parent, false)
        val item = getItem(position)!!

        fn(view, item, position, this)

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup) =
        getView(position, convertView, parent)


}