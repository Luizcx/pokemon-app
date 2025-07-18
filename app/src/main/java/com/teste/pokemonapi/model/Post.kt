package com.teste.pokemonapi.model

data class Pokemon (
    val id: Int,
    val name: String,
    val types: List<TypeSlot>
)

data class TypeSlot (
    val slot: Int,
    val type: Type
)

data class Type (
    val name: String,
    val url: String
)

data class PokemonListResponse(
    val results: List<PokemonSummary>
)

data class PokemonSummary(
    val name: String,
    val url: String
)