package com.example.libraryserviceandroidv2.libraryservice.client.game

import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

class GameCallAdapter : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        return null
    }

}