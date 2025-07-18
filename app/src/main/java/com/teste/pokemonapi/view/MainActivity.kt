package com.teste.pokemonapi.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teste.pokemonapi.R
import com.teste.pokemonapi.viewmodel.PokemonViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.RecyclerViewPokemon)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerViewPokemon)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = PokeAdapter()
        recyclerView.adapter = adapter

        val viewmodel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        viewmodel.pokemonList.observe(this) { list ->
            adapter.updateList(list)
        }

        viewmodel.fetchPokemonList()

        viewmodel.error.observe(this) { errorMessage ->
            errorMessage?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
        }

        val progressBar = findViewById<ProgressBar>(R.id.progressBarLoading)

        viewmodel.isLoading.observe(this) { loading ->
            progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        }


    }

}