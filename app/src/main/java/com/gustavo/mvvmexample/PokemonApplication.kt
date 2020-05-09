package com.gustavo.mvvmexample

import android.app.Application
import com.gustavo.mvvmexample.di.networkModule
import com.gustavo.mvvmexample.di.repositoryModule
import com.gustavo.mvvmexample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokemonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokemonApplication)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }

}