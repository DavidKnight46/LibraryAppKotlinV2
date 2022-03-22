package com.example.libraryserviceandroidv2.libraryservice.adapters.gameobjects

object GenreText {

    private lateinit var str: String

    fun setGenre(string: String){
        str = string
    }

    fun getGenre(): String{
        return str
    }
}