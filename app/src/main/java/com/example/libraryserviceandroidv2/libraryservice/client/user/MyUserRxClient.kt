package com.example.libraryserviceandroidv2.libraryservice.client.user

import com.example.libraryserviceandroidv2.libraryservice.model.UserModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MyUserRxClient {

    @GET("user?username={username}&password={password}")
    fun getAnUser(@Query("username") username: String,
                  @Query("password") password: String) : UserModel
}