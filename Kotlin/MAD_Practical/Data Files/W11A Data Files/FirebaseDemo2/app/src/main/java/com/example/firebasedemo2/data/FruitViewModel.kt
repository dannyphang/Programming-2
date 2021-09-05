package com.example.firebasedemo2.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FruitViewModel : ViewModel() {

    private var fruits = listOf<Fruit>() // Original data
    private val result = MutableLiveData<List<Fruit>>() // Search + filter + sort result

    private var name = ""       // Search
    private var categoryId = "" // Filter
    private var field = ""      // Sort
    private var reverse = false // Sort

    init {
        // TODO(14): Read all fruits -> launch block
        //           Populate [category] field


    }

    // TODO(15): Get search + filter + sort result
    private fun updateResult() {


        // TODO(23): Search + filter


        // TODO(24): Sort



    }

    // ---------------------------------------------------------------------------------------------

    fun getResult() = result

    // TODO(17): Return all categories
    suspend fun getCategories(): List<Category> {
        return listOf<Category>()
    }

    // TODO(21): Set [name] -> update result
    fun search(name: String) {

    }

    // TODO(22): Set [categoryId] -> update result
    fun filter(categoryId: String) {

    }

    // TODO(25): Set [field] and [reverse] -> update result
    fun sort(field: String): Boolean {
        return reverse
    }

    // ---------------------------------------------------------------------------------------------

    // TODO(30): Return a specific fruit (from local data)
    fun get(id: String): Fruit? {
        return null
    }

}