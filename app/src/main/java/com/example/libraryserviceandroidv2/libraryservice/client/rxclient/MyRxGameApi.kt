package com.example.libraryserviceandroidv2.libraryservice.client.rxclient

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyRxGameApi {

    @GET("libraryservice/gamecontroller/v2/getAllGames/{id}")
    fun GetAllGames(@Path("id") id: Int): Call<GameModel>
}