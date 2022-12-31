package com.artsmeet.app.core

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object ArtsMeet {
    val firebaseAuth = FirebaseAuth.getInstance()
    val db = Firebase.database.reference
    lateinit var applicationContext: Context
}