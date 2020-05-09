package com.gustavo.mvvmexample.data.remote

import com.gustavo.mvvmexample.model.PokemonReponse

class PokemonRepository(private val pokemonService: PokemonService) {
    /**
     * Pegar todos os Pokemons do serviço
     */
    suspend fun getPokemons(): PokemonReponse {
        return pokemonService.getPokemons()
    }

}