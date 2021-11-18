package com.example.libraryserviceandroidv2.libraryservice.client

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel

interface LibraryServiceClient {

    fun getAllGame():List<GameModel>

    fun getAGame(id: String)
}