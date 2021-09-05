package com.example.firebasedemo2.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

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
        viewModelScope.launch { 
            val categories = CATEGORIES.get().await().toObjects<Category>()

            // this is to get real time data, so do not use get()
            FRUITS.addSnapshotListener { snap, _ ->
                if(snap == null){
                    return@addSnapshotListener
                }
                fruits = snap.toObjects<Fruit>()
                for(f in fruits){
                    val category = categories.find { c -> c.id == f.categoryId }!!
                    f.category = category
                }

                updateResult()
            }
        }

    }

    // TODO(15): Get search + filter + sort result
    private fun updateResult() {
        var list = fruits

        // TODO(23): Search + filter


        // TODO(24): Sort


        result.value = list
    }

    // ---------------------------------------------------------------------------------------------

    fun getResult() = result

    // TODO(17): Return all categories
    suspend fun getCategories(): List<Category> {
        return CATEGORIES.get().await().toObjects<Category>()
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