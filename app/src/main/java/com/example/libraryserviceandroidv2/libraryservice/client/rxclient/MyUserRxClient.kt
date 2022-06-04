package com.example.libraryserviceandroidv2.libraryservice.client.rxclient

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MyUserRxClient {
    private var retrofit : Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("http://DESKTOP-F3IO7KQ:8080/libraryservice/")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    fun getRxClient(): Retrofit {
        return retrofit
    }
}