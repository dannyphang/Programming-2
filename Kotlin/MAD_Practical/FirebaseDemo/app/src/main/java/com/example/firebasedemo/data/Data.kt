package com.example.firebasedemo.data

import com.google.firebase.firestore.Blob
import com.google.firebase.firestore.DocumentId
import java.util.*

// TODO: Specify document id
// TODO: Add date and photo
data class Friend(
    @DocumentId
    var id   : String = "",
    var name : String = "",
    var age  : Int = 0,
    var date: Date = Date(),
    var photo: Blob = Blob.fromBytes(ByteArray(0))
)