package com.example.libraryserviceandroidv2.libraryservice.gameobjects

object User {

    private lateinit var id: String

    fun setID(id: String){
        this.id = id
    }

    fun getId(): String{
        return id
    }
}