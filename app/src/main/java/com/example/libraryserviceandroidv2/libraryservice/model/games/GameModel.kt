package com.example.libraryserviceandroidv2.libraryservice.model.games

import java.time.LocalDate

data class GameModel(val name:String, val rating: Int, val releaseDate: LocalDate){

    override fun toString(): String {
        return "GameModel(name='$name')"
    }
}
