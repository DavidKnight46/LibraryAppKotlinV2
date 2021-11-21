package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import java.net.URI
import java.net.URISyntaxException
import java.time.LocalDate

class LibraryServiceGameClientImpl : LibraryServiceGameClient {

    override fun getAllGame(): List<GameModel> {
        var mutableList = mutableListOf<GameModel>()

        mutableList.add(GameModel("", 1, LocalDate.now()))

        return  mutableList
    }

    override fun getAGame(id: String) {
        TODO("Not yet implemented")
    }

    override fun getGamesByRating(): List<GameModel> {
        TODO("Not yet implemented")
    }

    override fun getGamesByDeveloper(): List<GameModel> {
        TODO("Not yet implemented")
    }

    override fun getGamesByPublisher(): List<GameModel> {
        TODO("Not yet implemented")
    }

    private fun callEndpoint(){
        try {
            var execute = HttpClients.createDefault().execute(HttpGet(URI.create("")))

            do {
                var content = execute.entity.content

            }while(content.available() != 0)

        } catch (e: URISyntaxException){

        }

    }

}