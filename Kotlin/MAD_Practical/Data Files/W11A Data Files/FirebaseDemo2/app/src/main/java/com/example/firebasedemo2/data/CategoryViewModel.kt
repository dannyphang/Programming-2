package com.example.firebasedemo2.data

import androidx.lifecycle.ViewModel

class CategoryViewModel : ViewModel() {

    // TODO(7): Return all categories
    //          Populate [count] field
    suspend fun getAll(): List<Category> {
        return listOf<Category>()
    }

    // TODO(10): Return a specific category
    suspend fun get(id: String): Category? {
        return null
    }

    // TODO(11): Return all fruits under a specific category
    //           Populate [category] field
    suspend fun getFruits(id: String): List<Fruit> {
        return listOf<Fruit>()
    }

}