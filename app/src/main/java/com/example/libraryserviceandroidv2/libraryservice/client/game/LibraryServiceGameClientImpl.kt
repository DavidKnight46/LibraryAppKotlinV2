package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.client.rxclient.MyGameRxClient
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import retrofit2.Response
import java.util.stream.Collectors

class LibraryServiceGameClientImpl : LibraryServiceGameClient {

    override fun getDetailsGame(id: Int) : List<GameModel> {
        return callGameAPIEndpoint(id)
            .body()?.stream()?.collect(Collectors.toList()) as MutableList
    }

    private fun callGameAPIEndpoint(userId: Int): Response<List<GameModel>> {
        return MyGameRxClient
            .getRxClient()
            .create(MyRxGameApi::class.java)
            .GetAllGames(userId)
            .execute()

    }

}