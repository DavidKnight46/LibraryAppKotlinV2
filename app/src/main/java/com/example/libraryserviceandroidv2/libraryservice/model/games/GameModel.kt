package com.example.libraryserviceandroidv2.libraryservice.model.games

import java.time.LocalDate

data class GameModel(val gameName:String,
                     val gameGenre: Int,
                     val gameRating: Float,
                     val imageUrl: String,
                     val preOrdered: Boolean,
                     val releaseDate: LocalDate){

    override fun toString(): String {
        return "GameModel(name='$gameName')"
    }
}
