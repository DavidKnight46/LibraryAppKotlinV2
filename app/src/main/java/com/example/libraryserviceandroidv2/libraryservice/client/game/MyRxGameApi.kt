package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyRxGameApi {

    @GET("gamecontroller/v2/getAllGames/{id}")
    fun GetAllGames(@Path("id") id: Int): Call<List<GameModel>>
}