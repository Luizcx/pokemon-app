package com.teste.pokemonapi.repository

import com.teste.pokemonapi.model.PokemonListResponse
import com.teste.pokemonapi.network.RetrofitInstance
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class PokeRepository {
    private val api = RetrofitInstance.api

    fun getPokemonList(onResult: (PokemonListResponse?) -> Unit) {
        val call = api.getPokemonList(151, 0)
        call.enqueue(object : Callback<PokemonListResponse>{
            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else {
                    onResult(null)
                }
            }

            override fun onFailure(call: Call   <PokemonListResponse>, t: Throwable) {
                onResult(null)
            }
        })

    }
}