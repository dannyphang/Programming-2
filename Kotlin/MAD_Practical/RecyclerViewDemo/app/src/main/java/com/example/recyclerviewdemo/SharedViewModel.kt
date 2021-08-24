package com.example.recyclerviewdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.net.URL

// https://picsum.photos/v2/list?limit=100
// https://picsum.photos/id/$id/500/500.webp

// TODO: Data class --------------------------------------------------------------------------------
@Serializable
data class Photo(
    var id: String,
    var author: String,
    var width: Int,
    var height: Int,
    var url: String,
    var download_url: String,
) {
    val photo = "https://picsum.photos/id/$id/500/500.webp"
}

// TODO: View model --------------------------------------------------------------------------------

class SharedViewModel : ViewModel() {
    // TODO: Change to List<Photo>
    val photos = MutableLiveData<List<Photo>>()

    init {
        // TODO: Load data from Internet
        // viewModelScope allow us to lunch background job
        viewModelScope.launch () {
            val str = withContext(Dispatchers.IO){
                URL("https://picsum.photos/v2/list?limit=100").readText()
            }
            photos.value = Json.decodeFromString(str)
        }

    }

    // TODO: Get photo by id
    fun get(id: String) = photos.value?.find { p -> p.id == id }
}