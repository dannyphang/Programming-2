package com.example.imagedemo.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.imagedemo.R
import com.example.imagedemo.data.Image

class ImageAdapter (
    // TODO(7): Add baseUri parameter

    val fn: (ViewHolder, Image) -> Unit = { _, _ -> }
) : ListAdapter<Image, ImageAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(a: Image, b: Image)    = a.id == b.id
        override fun areContentsTheSame(a: Image, b: Image) = a == b
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val root = view
        val img: ImageView = view.findViewById(R.id.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = getItem(position)

        // TODO(8): Show image in ImageView


        fn(holder, image)
    }

}