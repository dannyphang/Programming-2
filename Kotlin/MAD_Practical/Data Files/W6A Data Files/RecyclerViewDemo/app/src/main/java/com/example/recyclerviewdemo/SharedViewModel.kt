package com.example.recyclerviewdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// https://picsum.photos/v2/list?limit=100
// https://picsum.photos/id/$id/500/500.webp

// TODO: Data class --------------------------------------------------------------------------------

data class Photo(
    var id: String,
    var author: String,
    var width: Int,
    var height: Int,
    var url: String,
    var download_url: String,
)

// TODO: View model --------------------------------------------------------------------------------

class SharedViewModel : ViewModel() {
    // TODO: Change to List<Photo>
    val photos = MutableLiveData<String>()

    init {
        // TODO: Load data from Internet

    }

    // TODO: Get photo by id
    fun get(id: String) = 0
}