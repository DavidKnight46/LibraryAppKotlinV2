package com.example.libraryserviceandroidv2.libraryservice.model.games

data class GameModel(val id: Int,
                     val gameName:String,
                     val gameGenre: String,
                     val platform: String,
                     val gameRating: Float,
                     val imageUrl: String,
                     val preOrdered: Boolean,
                     val releaseDate: String){

    override fun toString(): String {
        return "GameModel(name='$gameName')"
    }
}
