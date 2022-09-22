package com.example.libraryserviceandroidv2.libraryservice.gameobjects

object User {

    private lateinit var userName: String

    fun setUsername(id: String){
        this.userName = id
    }

    fun getUserName(): String{
        return userName
    }
}