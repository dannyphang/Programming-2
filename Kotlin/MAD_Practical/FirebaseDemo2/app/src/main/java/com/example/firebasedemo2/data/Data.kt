package com.example.firebasedemo2.data

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class Category(
    @DocumentId
    var id: String = "",
    var name: String = "",
) {
    // TODO(1): Additional field: [count] and [toString]
    @get: Exclude
    var count: Int = 0

    override fun toString() = name
}

data class Fruit(
    @DocumentId
    var id: String = "",
    var name: String = "",
    var price: Double = 0.00,
    var categoryId: String = "",
) {
    // TODO(2): Additional field: [category]
    @get: Exclude
    var category: Category = Category()
}

// -------------------------------------------------------------------------------------------------

// TODO(3): Shortcuts to Firestore collections [categories] and [fruits]
val CATEGORIES = Firebase.firestore.collection("categories")
val FRUITS = Firebase.firestore.collection("fruits")

// -------------------------------------------------------------------------------------------------

fun RESTORE_DATA() {
    val categories = listOf(
        Category("L", "Local"),
        Category("I", "Imported"),
    )

    val fruits = listOf(
        Fruit("F01", "Banana", 0.00, "L"),
        Fruit("F02", "Papaya", 0.00, "L"),
        Fruit("F03", "Coconut", 0.00, "L"),
        Fruit("F04", "Apple", 0.00, "I"),
        Fruit("F05", "Orange", 0.00, "I"),
        Fruit("F06", "Watermelon", 0.00, "L"),
        Fruit("F07", "Strawberry", 0.00, "I"),
        Fruit("F08", "Honeydew", 0.00, "I"),
        Fruit("F09", "Durian", 0.00, "L"),
        Fruit("F10", "Grape", 0.00, "I"),
    )

    // TODO(4): Insert categories + fruits data
    for (c in categories) {
        CATEGORIES.document(c.id).set(c)
    }

    for (f in fruits) {
        FRUITS.document(f.id).set(f)
    }
}