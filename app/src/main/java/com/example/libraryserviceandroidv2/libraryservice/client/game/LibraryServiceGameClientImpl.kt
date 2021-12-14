package com.example.libraryserviceandroidv2.libraryservice.client.game

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import java.net.URI
import java.net.URISyntaxException

class LibraryServiceGameClientImpl : LibraryServiceGameClient {

    override fun getDetailsGame(id: String) {
        TODO("Not yet implemented")
    }

    private fun callEndpoint(endPoint: String) {
        try {

            var uriStr = String.format(
                "http://localhost:8080/libraryservice/game/%s?user=%2&sortBy=%sorder=%s",
                endPoint
            )

            var execute = HttpClients.createDefault().execute(HttpGet(URI.create(uriStr)))

            do {
                var content = execute.entity.content

            } while (content.available() != 0)

        } catch (e: URISyntaxException) {

        }

    }

}