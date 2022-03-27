package com.example.libraryserviceandroidv2.libraryservice.gameobjects

object PlatformText {

    private lateinit var str: String

    fun setPlatform(string: String){
        str = string
    }

    fun getPlatform(): String{
        return str
    }
}