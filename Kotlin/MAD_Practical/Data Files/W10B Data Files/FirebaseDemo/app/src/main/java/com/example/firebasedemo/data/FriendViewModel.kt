package com.example.firebasedemo.data

import androidx.lifecycle.ViewModel

class FriendViewModel : ViewModel() {
    // TODO: Initialization


    fun get(id: String): Friend? {
        // TODO
        return null
    }

    fun getAll() {
        // TODO

    }

    fun delete(id: String) {
        // TODO

    }

    fun deleteAll() {
        // TODO

    }

    fun set(f: Friend) {
        // TODO

    }

    //----------------------------------------------------------------------------------------------

    fun idExists(id: String): Boolean {
        // TODO: Duplicated id?
        return false
    }

    fun nameExists(name: String): Boolean {
        // TODO: Duplicated name?
        return false
    }

    fun validate(f: Friend, insert: Boolean = true): String {
        val regexId = Regex("""^[0-9A-Z]{4}$""")
        var e = ""

        if (insert) {
            e += if (f.id == "") "- Id is required.\n"
            else if (!f.id.matches(regexId)) "- Id format is invalid.\n"
            else if (idExists(f.id)) "- Id is duplicated.\n"
            else ""
        }

        e += if (f.name == "") "- Name is required.\n"
        else if (f.name.length < 3) "- Name is too short.\n"
        else if (nameExists(f.name)) "- Name is duplicated.\n"
        else ""

        e += if (f.age == 0) "- Age is required.\n"
        else if (f.age < 18) "- Underage.\n"
        else ""

        /*
        e += if (f.photo.toBytes().isEmpty()) "- Photo is required.\n"
        else ""
        */

        return e
    }
}