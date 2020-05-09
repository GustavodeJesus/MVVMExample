package com.gustavo.mvvmexample.di

import com.gustavo.mvvmexample.data.remote.PokemonRepository
import com.gustavo.mvvmexample.data.remote.PokemonService
import com.gustavo.mvvmexample.viewmodel.PokemonViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://www.pokemon.com/us/api/pokedex/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    fun provideForecastApi(retrofit: Retrofit): PokemonService =
        retrofit.create(PokemonService::class.java)


    factory { provideOkHttpClient() }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}

val repositoryModule = module {

    fun provideRepository(pokemonService: PokemonService): PokemonRepository {
        return PokemonRepository(pokemonService)
    }

    single { provideRepository(get()) }
}

val viewModelModule = module {

    viewModel { PokemonViewModel(get()) }
}

