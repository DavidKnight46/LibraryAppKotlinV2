package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel

interface LibraryServiceGameClient {

    fun getAllGame():List<GameModel>

    fun getAGame(id: String)

    fun getGamesByRating(): List<GameModel>

    fun getGamesByDeveloper(): List<GameModel>

    fun getGamesByPublisher(): List<GameModel>
}