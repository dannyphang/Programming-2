package com.example.logindemo.data

import android.content.Context
import android.graphics.BitmapFactory
import com.example.logindemo.R
import com.example.logindemo.util.toBlob
import com.google.firebase.firestore.Blob
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class User (
    @DocumentId
    var id      : String = "",
    var email   : String = "",
    var password: String = "",
    var name    : String = "",
    var photo   : Blob?  = null,
)

val USERS = Firebase.firestore.collection("users")

fun RESTORE_USERS(ctx: Context) {
    // (1) DELETE users
    USERS.get().addOnSuccessListener { snap ->
        for (doc in snap.documents) {
            USERS.document(doc.id).delete()
        }

        // (2) ADD users
        val user1 = User(
            email    = "1@gmail.com",
            password = "password",
            name     = "Bae Suzy",
            photo    = BitmapFactory.decodeResource(ctx.resources, R.drawable.suzy).toBlob(),
        )
        USERS.document().set(user1)

        val user2 = User(
            email    = "2@gmail.com",
            password = "password",
            name     = "Lee Jieun",
            photo    = BitmapFactory.decodeResource(ctx.resources, R.drawable.jieun).toBlob(),
        )
        USERS.document().set(user2)
    }
}