package com.example.d2capplication.data

import com.google.firebase.firestore.Blob
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class Product(
    @DocumentId
    var id: String = "",
    var name: String = "",
    var price: Double = 0.00,
    var photo: Blob = Blob.fromBytes(ByteArray(0)),
    var doublePoint: Boolean = false,
    var categoryId: String = "",
) {
    @get: Exclude
    var category: Category = Category()
}

data class Category(
    @DocumentId
    var id: String = "",
    var name: String = ""
) {
    @get: Exclude
    var count: Int = 0

    override fun toString() = name
}

val PRODUCT = Firebase.firestore.collection("Product")
val CATEGORY = Firebase.firestore.collection("Category")

