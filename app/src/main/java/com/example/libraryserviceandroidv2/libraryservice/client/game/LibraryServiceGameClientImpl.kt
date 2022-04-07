package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.client.rxclient.MyRxGameApi
import com.example.libraryserviceandroidv2.libraryservice.client.rxclient.MyGameRxClient

class LibraryServiceGameClientImpl : LibraryServiceGameClient {

    override fun getDetailsGame(id: Int) {
        callEndpoint(id)
    }

    private fun callEndpoint(endPoint: Int) {

        var myRxGameApi = MyGameRxClient
            .getRxClient()
            .create(MyRxGameApi::class.java)

        var call = myRxGameApi
            .GetAllGames(endPoint)
            .execute()

        System.out.println("smurf")
    }

}