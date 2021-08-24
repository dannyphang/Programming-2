package com.example.roomdemo1.util

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.roomdemo1.R

// TODO: Convert to extension method
fun Fragment.errorDialog(text: String) {
    AlertDialog.Builder(context)
        .setIcon(R.drawable.ic_error)
        .setTitle("Error")
        .setMessage(text)
        .setPositiveButton("Dismiss", null)
        .show()
}
