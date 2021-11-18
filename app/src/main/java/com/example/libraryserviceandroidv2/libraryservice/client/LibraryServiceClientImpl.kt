package com.example.libraryserviceandroidv2.libraryservice.client

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import java.net.URI
import java.net.URISyntaxException
import java.time.LocalDate

class LibraryServiceClientImpl : LibraryServiceClient {

    override fun getAGame(id: String) {
        TODO("Not yet implemented")
    }

    override fun getAllGame(): List<GameModel> {
        var mutableList = mutableListOf<GameModel>()

        mutableList.add(GameModel("", 1, LocalDate.now()))

        return  mutableList
    }

    private fun callEndpoint(){
        try {
            var execute = HttpClients.createDefault().execute(HttpGet(URI.create("")))

            var content = execute.entity.content

        } catch (e: URISyntaxException){

        }

    }

}