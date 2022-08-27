package com.example.libraryserviceandroidv2.libraryservice.client.game

import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import retrofit2.Call
import retrofit2.http.*

interface MyRxGameApi {

    @GET("gamecontroller/v2/getAllGames/{userName}")
    fun GetAllGames(@Path("userName") userName: String): Call<List<GameModel>>

    @POST("gamecontroller/v2/addNewGame/{id}")
    fun addAnGame(@Path("id") id: String,
                  @Body gameModel: GameModel): Call<Void>

    @PUT("gamecontroller/v2/updateGame")
    fun updateAnGame(@Body gameModel: GameModel): Call<Void>

    @DELETE("gamecontroller/v2/deleteGame")
    fun deleteAnGame(@Body gameModel: GameModel): Call<Void>
}