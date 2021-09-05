package com.example.firebasedemo2.data

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.tasks.await

class CategoryViewModel : ViewModel() {

    // TODO(7): Return all categories
    //          Populate [count] field
    suspend fun getAll(): List<Category> {
        val categories = CATEGORIES.get().await().toObjects<Category>()

        for(c in categories){
            c.count = FRUITS.whereEqualTo("categoryId", c.id).get().await().size()
        }

        return categories
    }

    // TODO(10): Return a specific category
    suspend fun get(id: String): Category? {
        return CATEGORIES.document(id).get().await().toObject<Category>()
    }

    // TODO(11): Return all fruits under a specific category
    //           Populate [category] field
    suspend fun getFruits(id: String): List<Fruit> {
        val fruits = FRUITS.whereEqualTo("categoryId", id).get().await().toObjects<Fruit>()
        val category = get(id)

        for (f in fruits) {
            f.category = category!!
        }

        return fruits
    }

}