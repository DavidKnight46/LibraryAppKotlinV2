package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel

interface LibraryServiceGameClient {

    fun getDetailsGame(id: Int) : List<GameModel>

}