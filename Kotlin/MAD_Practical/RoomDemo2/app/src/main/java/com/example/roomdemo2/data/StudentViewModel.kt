package com.example.roomdemo2.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdemo2.App.Companion.db
import kotlinx.coroutines.launch

class StudentViewModel : ViewModel() {
    // TODO(18): Live data (query and search result)


    // TODO(13): getAllCustom
    fun getAllCustom() = db.studentDao.getAllCustom()

    fun getAll() = db.studentDao.getAll()

    fun get(id: String) = db.studentDao.get(id)

    fun insert(s: Student) = viewModelScope.launch { db.studentDao.insert(s) }

    fun update(s: Student) = viewModelScope.launch { db.studentDao.update(s) }

    fun delete(s: Student) = viewModelScope.launch { db.studentDao.delete(s) }

    fun getAllPrograms() = db.programDao.getAll()

    // TODO(23): validate


}