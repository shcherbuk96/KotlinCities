package com.example.yauheni_shcharbuk.kotlinepamexample.di

import com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_main.MainActivityModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModul {

    @Provides
    @Singleton
    fun networkModel(): MainActivityModel = MainActivityModel()
}