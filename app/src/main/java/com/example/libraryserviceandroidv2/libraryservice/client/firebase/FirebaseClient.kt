package com.example.libraryserviceandroidv2.libraryservice.client.firebase

import com.google.firebase.auth.FirebaseAuth

class FirebaseClient(val firebaseAuth: FirebaseAuth) {

    fun checkUserAlready(email: String, password: String): Boolean {


            return firebaseAuth.signInWithEmailAndPassword(
                email,
                password
            ).isSuccessful
    }
}