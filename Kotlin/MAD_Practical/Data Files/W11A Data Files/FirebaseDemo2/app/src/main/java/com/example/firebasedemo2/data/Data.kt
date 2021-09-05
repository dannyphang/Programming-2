package com.example.firebasedemo2.data

import com.google.firebase.firestore.DocumentId

data class Category(
    @DocumentId
    var id: String = "",
    var name: String = "",
) {
    // TODO(1): Additional field: [count] and [toString]

}

data class Fruit(
    @DocumentId
    var id: String = "",
    var name: String = "",
    var price: Double = 0.00,
    var categoryId: String = "",
) {
    // TODO(2): Additional field: [category]

}

// -------------------------------------------------------------------------------------------------

// TODO(3): Shortcuts to Firestore collections [categories] and [fruits]
val CATEGORIES = 0
val FRUITS = 0

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


}