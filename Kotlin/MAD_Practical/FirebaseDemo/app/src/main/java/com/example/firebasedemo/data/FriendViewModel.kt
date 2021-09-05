package com.example.firebasedemo.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FriendViewModel : ViewModel() {
    // TODO: Initialization
    private val col = Firebase.firestore.collection("friends")
    private val friends = MutableLiveData<List<Friend>>()

    // init will run when the document being modified everytime
    init{
        col.addSnapshotListener { snap, _ -> friends.value = snap?.toObjects<Friend>() }
    }

//    suspend fun get(id: String): Friend? {
//        // TODO
//        return col.document(id).get().await().toObject<Friend>()
//    }

    fun get(id: String): Friend? {
        return friends.value?.find { f -> f.id == id }
    }

    fun getAll() = friends

    fun delete(id: String) {
        // TODO
        col.document(id).delete()
    }

    fun deleteAll() {
        // TODO
//        col.get().addOnSuccessListener { snap -> snap.documents.forEach { doc -> delete(doc.id) } }
        friends.value?.forEach { f -> delete(f.id) }
    }

    fun set(f: Friend) {
        // TODO
        col.document(f.id).set(f)
    }

    //----------------------------------------------------------------------------------------------

//    private suspend fun idExists(id: String): Boolean {
//        // TODO: Duplicated id?
//        return col.document(id).get().await().exists()
//    }

    private fun idExists(id: String): Boolean {
        return friends.value?.any { f -> f.id == id } ?: false
    }

//    private suspend fun nameExists(name: String): Boolean {
//        // TODO: Duplicated name?
//        return col.whereEqualTo("name", name).get().await().size() > 0
//    }

    private fun nameExists(name: String): Boolean {
        return friends.value?.any { f -> f.name == name } ?: false
    }

    fun validate(f: Friend, insert: Boolean = true): String {
        val regexId = Regex("""^[0-9A-Z]{5}$""")
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

        e += if (f.photo.toBytes().isEmpty()) "- Photo is required.\n"
        else ""

        return e
    }
}