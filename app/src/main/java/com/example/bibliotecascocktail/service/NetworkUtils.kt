package com.example.bibliotecascocktail.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object {

        private val URL_BASE = "https://www.thecocktaildb.com/api/"

    fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    }
}