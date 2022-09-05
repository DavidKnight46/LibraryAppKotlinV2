package com.example.libraryserviceandroidv2.libraryservice.client.user

import com.example.libraryserviceandroidv2.libraryservice.model.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MyUserRxClient {

    @POST("usercontroller/checkUser")
    fun getAnUser(@Body userModel: UserModel) : Call<Boolean>

    @POST("usercontroller/addUser")
    fun createAnUser(@Body userModel: UserModel) : Call<Boolean>
}