package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.model.UserModel
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import retrofit2.Response

interface LibraryServiceGameClient {

    fun getDetailsGame(id: Int) : List<GameModel>

    fun getAnUser(username: String, password: String): UserModel?

}