package com.example.roomdemo1.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdemo1.App.Companion.db
import kotlinx.coroutines.launch

class FruitViewModel : ViewModel() {

    // TODO
    fun getAll() = db.fruitDao.getAll()

    // TODO
    fun get(id: Int) = db.fruitDao.get(id)

    // TODO
    fun insert(f: Fruit) = viewModelScope.launch { db.fruitDao.insert(f) } // use viewModelScope becuz .insert is a suspend

    // TODO
    fun update(f: Fruit) = viewModelScope.launch { db.fruitDao.update(f) }

    // TODO
    fun delete(f: Fruit) = viewModelScope.launch { db.fruitDao.delete(f) }

    // TODO
    fun deleteAll() = viewModelScope.launch { db.fruitDao.deleteAll() }

    // TODO
    fun validate(f: Fruit): String {
        var err = ""

        if (f.name == "") {
            err += "- Name is required. \n"
        }

        if (f.price == 0.0) {
            err += "- Price is required. \n"
        }
        else if (f.price < 0.01 || f.price > 99.99) {
            err += "- Price must between 0.01 - 99.99. \n"
        }
        return err
    }

}