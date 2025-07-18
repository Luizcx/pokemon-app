package com.teste.pokemonapi.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.teste.pokemonapi.R
import com.teste.pokemonapi.model.PokemonSummary
import com.teste.pokemonapi.viewmodel.PokemonViewModel

class PokeAdapter : RecyclerView.Adapter<PokeAdapter.PokeViewHolder>(){

    private var pokemonList = listOf<PokemonSummary>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val view = LayoutInflater.from((parent.context))
            .inflate(R.layout.item_pokemon, parent, false)
        return PokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int = pokemonList.size

    fun updateList(newList: List<PokemonSummary>) {
        pokemonList = newList
        notifyDataSetChanged()
    }

    class PokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textViewNomesPokemon)

        fun bind(pokemon: PokemonSummary) {
            nameTextView.text = pokemon.name.capitalize()
        }
    }
}