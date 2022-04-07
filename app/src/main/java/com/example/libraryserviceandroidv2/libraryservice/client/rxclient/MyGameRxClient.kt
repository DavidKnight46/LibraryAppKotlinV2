package com.example.libraryserviceandroidv2.libraryservice.client.rxclient

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MyGameRxClient {

    private var retrofit : Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8080/")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    fun getRxClient(): Retrofit{
        return retrofit
    }


}