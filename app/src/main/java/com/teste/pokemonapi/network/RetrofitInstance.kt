package com.teste.pokemonapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
val retrofit: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    val api: PokeServiceApi by lazy {
        retrofit.create(PokeServiceApi::class.java)
    }
}