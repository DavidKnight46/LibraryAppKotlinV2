package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import retrofit2.Call
import retrofit2.http.*

interface MyRxGameApi {

    @POST("createUserGameTable/{tableName}")
    fun createUserGameTable(@Path("tableName") tableName: String) : Call<Boolean>

    @GET("getAllGames/{userName}")
    fun GetAllGames(@Path("userName") userName: String): Call<List<GameModel>>

    @POST("addNewGame/{id}")
    fun addAnGame(@Path("id") id: String,
                  @Body gameModel: GameModel): Call<Void>

    @PUT("updateGame")
    fun updateAnGame(@Body gameModel: GameModel): Call<Void>

    @DELETE("deleteGame")
    fun deleteAnGame(@Body gameModel: GameModel): Call<Void>
}