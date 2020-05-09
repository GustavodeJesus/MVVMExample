package com.gustavo.mvvmexample.data.remote

import com.gustavo.mvvmexample.model.PokemonReponse
import retrofit2.http.GET

interface PokemonService {
    @GET("kalos")
    suspend fun getPokemons(): PokemonReponse
}