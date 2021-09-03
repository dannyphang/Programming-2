package com.example.roomdemo2.data

import androidx.lifecycle.ViewModel
import com.example.roomdemo2.App.Companion.db

class ProgramViewModel : ViewModel() {
    // TODO(3): getAllCustom
    fun getAllCustom() = db.programDao.getAllCustom()

    fun getAll() = db.programDao.getAll()

    fun get(id: String) = db.programDao.get(id)

    // TODO(9): getStudentsByProgramId
    fun getStudentByProgramId(programId: String) = db.studentDao.getStudentByProgramId(programId)

}