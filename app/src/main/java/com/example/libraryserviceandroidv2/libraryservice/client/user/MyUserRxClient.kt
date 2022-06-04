package com.example.libraryserviceandroidv2.libraryservice.client.user

import com.example.libraryserviceandroidv2.libraryservice.model.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyUserRxClient {

    @GET("user/getuser")
    fun getAnUser(@Query("username") username: String,
                  @Query("password") password: String) : Call<UserModel>
}