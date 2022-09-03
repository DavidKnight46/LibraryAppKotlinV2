package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel

interface LibraryServiceGameClient {

    fun getDetailsGame(userName: String): List<GameModel>

    fun addAnGame(userName: String, gameModel: GameModel)

    fun updateAnGame(gameModel: GameModel)

    fun deleteAnGame(gameModel: GameModel)

}