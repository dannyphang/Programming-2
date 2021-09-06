package com.example.d2capplication.data

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CategoryViewModel: ViewModel() {
    private val col = Firebase.firestore.collection("Category")

}