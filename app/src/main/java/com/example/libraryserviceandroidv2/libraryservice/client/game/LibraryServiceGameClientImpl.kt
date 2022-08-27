package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.client.rxclient.MyGameRxClient
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import retrofit2.Response
import java.util.stream.Collectors

class LibraryServiceGameClientImpl : LibraryServiceGameClient {

    override fun getDetailsGame(userName: String): ArrayList<GameModel> {
        return callGameAPIEndpoint(userName)
            .body()?.stream()?.collect(Collectors.toList()) as ArrayList
    }

    override fun addAnGame(gameModel: GameModel) {
        return callAddGameAPIEndpoint(gameModel)
    }

    override fun updateAnGame(gameModel: GameModel) {
        callUpdateAPIEndpoint(gameModel);
    }

    override fun deleteAnGame(gameModel: GameModel) {
        return callDeleteAPIEndpoint(gameModel)
    }

    private fun callGameAPIEndpoint(userName: String): Response<List<GameModel>> {
        return MyGameRxClient
            .getRxClient()
            .create(MyRxGameApi::class.java)
            .GetAllGames(userName)
            .execute()
    }

    private fun callAddGameAPIEndpoint(gameModel: GameModel) {
        MyGameRxClient
            .getRxClient()
            .create(MyRxGameApi::class.java)
            .addAnGame(gameModel.name, gameModel)
            .execute()
    }

    private fun callDeleteAPIEndpoint(gameModel: GameModel) {
        MyGameRxClient.getRxClient().create(MyRxGameApi::class.java).deleteAnGame(gameModel)
            .execute()
    }

    private fun callUpdateAPIEndpoint(gameModel: GameModel){
        MyGameRxClient.getRxClient().create(MyRxGameApi::class.java).updateAnGame(gameModel)
            .execute()
    }
}