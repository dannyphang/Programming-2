package com.example.roomdemo2.data

import androidx.lifecycle.*
import com.example.roomdemo2.App.Companion.db
import kotlinx.coroutines.launch

class StudentViewModel : ViewModel() {
    // TODO(18): Live data (query and search result)
    val query = MutableLiveData("")
    val result = query.switchMap { db.studentDao.getAllCustom(it) }

    // TODO(13): getAllCustom
    fun getAllCustom() = db.studentDao.getAllCustom()

    fun getAll() = db.studentDao.getAll()

    fun get(id: String) = db.studentDao.get(id)

    fun insert(s: Student) = viewModelScope.launch { db.studentDao.insert(s) }

    fun update(s: Student) = viewModelScope.launch { db.studentDao.update(s) }

    fun delete(s: Student) = viewModelScope.launch { db.studentDao.delete(s) }

    fun getAllPrograms() = db.programDao.getAll()

    // TODO(32): getPrograms
    suspend fun getPrograms() = db.programDao.getPrograms()

    // TODO(23): validate
    suspend fun validate(s: Student, isInsert: Boolean = true): String {
        var regexId = Regex("""^\d{2}[A-Z]{3}\d{5}$""")
        // ^ -> Start of pattern
        // $ -> End of pattern
        var err = ""

        if(isInsert){
            // only run if insert
            if (s.id == "") {
                err += "- Id is required.\n"
            }
            else if (!s.id.matches(regexId)) {
                err += "- Id format is invalid.\n"
            }
            else if (db.studentDao.getCount(s.id) > 0) {
                err += "- Id is duplicated.\n"
            }
        }

        if(s.name == ""){
            err += "- Name is required.\n"
        }
        return err
    }

}