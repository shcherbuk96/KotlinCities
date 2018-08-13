package com.example.yauheni_shcharbuk.kotlinepamexample.di

import com.example.yauheni_shcharbuk.kotlinepamexample.api.Api
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModul {

    @Provides
    @Singleton
    fun api(): Api = Api.create()
}