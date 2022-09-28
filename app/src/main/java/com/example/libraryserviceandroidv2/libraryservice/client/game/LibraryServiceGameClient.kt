package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel

interface LibraryServiceGameClient {

    fun createGameUserTable(tableName: String): Boolean

    fun getDetailsGame(userName: String): List<GameModel>

    fun addAnGame(gameModel: GameModel)

    fun updateAnGame(gameModel: GameModel)

    fun deleteAnGame(userName: String, gameName: String)

}