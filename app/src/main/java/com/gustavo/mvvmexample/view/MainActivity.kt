package com.gustavo.mvvmexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gustavo.mvvmexample.R
import com.gustavo.mvvmexample.viewmodel.PokemonViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val pokemonModel: PokemonViewModel by viewModel()

        pokemonModel.resultPokemons.observe(this, Observer {
            rv_pokemon.layoutManager = LinearLayoutManager(this)
            rv_pokemon.adapter = PokemonAdapter(it)
        })


    }
}