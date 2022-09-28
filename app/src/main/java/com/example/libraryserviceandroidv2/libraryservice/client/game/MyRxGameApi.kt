package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import retrofit2.Call
import retrofit2.http.*

interface MyRxGameApi {

    @POST("createUserGameTable/{tableName}")
    fun createUserGameTable(@Path("tableName") tableName: String): Call<Boolean>

    @GET("getAllGames/{userName}")
    fun GetAllGames(@Path("userName") userName: String): Call<List<GameModel>>

    @POST("addNewGame")
    fun addAnGame(@Body gameModel: GameModel): Call<Void>

    @PUT("updateGame")
    fun updateAnGame(@Body gameModel: GameModel): Call<Void>

    @DELETE("deleteGame/{userName}/{gameName}")
    fun deleteAnGame(
        @Path("userName") userName: String?,
        @Path("gameName") gameName: String?
    ): Call<Void>
}