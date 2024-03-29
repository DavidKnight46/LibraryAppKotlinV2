package com.example.libraryserviceandroidv2.libraryservice.model.games

data class GameModel(
    val gameName: String,
    val gameGenre: String,
    val platform: String,
    val gameRating: Float,
    val imageUrl: String,
    val isPreOrdered: Boolean,
    val releaseDate: String,
    val userName: String
) {

    override fun toString(): String {
        return "$gameName"
    }
}
