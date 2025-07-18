package com.teste.pokemonapi.network

import com.teste.pokemonapi.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface PokeServiceApi {
    @GET("pokemon")
    fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): Call<PokemonListResponse>

}