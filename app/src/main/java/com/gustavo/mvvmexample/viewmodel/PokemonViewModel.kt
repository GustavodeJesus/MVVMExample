package com.gustavo.mvvmexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gustavo.mvvmexample.data.remote.PokemonRepository
import com.gustavo.mvvmexample.model.PokemonReponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class PokemonViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    private val viewModelJob = SupervisorJob()

    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    val resultPokemons = MutableLiveData<PokemonReponse>()


    init {
        getPokemons()
    }


    private fun getPokemons() {

        uiScope.launch {

            resultPokemons.value = pokemonRepository.getPokemons()

        }

    }

}