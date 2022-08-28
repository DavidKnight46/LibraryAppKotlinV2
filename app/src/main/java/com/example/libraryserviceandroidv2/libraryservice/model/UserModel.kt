package com.example.libraryserviceandroidv2.libraryservice.model

data class UserModel(val userName: String, val userPassword: String){
    override fun toString(): String {
        return "$userName"
    }
}
