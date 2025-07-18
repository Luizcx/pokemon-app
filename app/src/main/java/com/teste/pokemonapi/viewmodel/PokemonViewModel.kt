package com.teste.pokemonapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teste.pokemonapi.model.PokemonSummary
import com.teste.pokemonapi.repository.PokeRepository

class PokemonViewModel : ViewModel() {

    private val repository = PokeRepository()

    private val _pokemonList = MutableLiveData<List<PokemonSummary>>()
    val pokemonList: LiveData<List<PokemonSummary>> = _pokemonList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    init {
        fetchPokemonList()
    }

    fun fetchPokemonList() {
        _isLoading.value = true
        _error.value = null

        repository.getPokemonList { result ->
            _isLoading.value = false
            if (result != null){
                _pokemonList.value = result.results
            }
            else {
                _error.value = "Erro ao listar os Pokémons"
            }}
    }

}