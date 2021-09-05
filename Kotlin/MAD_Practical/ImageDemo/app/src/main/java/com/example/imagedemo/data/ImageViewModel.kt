package com.example.imagedemo.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagedemo.App.Companion.db
import kotlinx.coroutines.launch

class ImageViewModel : ViewModel() {
    suspend fun get(id: Int) = db.imageDao.get(id)
    fun getAll() = db.imageDao.getAll()
    fun insert(image: Image) = viewModelScope.launch { db.imageDao.insert(image) }
    fun update(image: Image) = viewModelScope.launch { db.imageDao.update(image) }
    fun delete(image: Image) = viewModelScope.launch { db.imageDao.delete(image) }
    fun deleteAll() = viewModelScope.launch { db.imageDao.deleteAll() }
}