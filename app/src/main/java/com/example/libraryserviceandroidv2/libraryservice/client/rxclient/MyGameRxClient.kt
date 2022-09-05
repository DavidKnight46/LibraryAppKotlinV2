package com.example.libraryserviceandroidv2.libraryservice.client.rxclient

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MyGameRxClient {

    private var retrofit : Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("http://Libraryserviceappgameenv-env.eba-x8pqh8r4.eu-west-2.elasticbeanstalk.com/libraryservice/gamecontroller/v2/")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    fun getRxClient(): Retrofit{
        return retrofit
    }


}