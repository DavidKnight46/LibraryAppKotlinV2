package com.example.libraryserviceandroidv2.libraryservice.model

data class GameModel(val name:String, val rating: Int){

    override fun toString(): String {
        return "GameModel(name='$name')"
    }
}
