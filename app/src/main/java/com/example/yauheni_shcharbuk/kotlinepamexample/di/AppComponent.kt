package com.example.yauheni_shcharbuk.kotlinepamexample.di

import com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_main.MainActivity
import com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_main.MainActivityModel
import com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_main.MainActivityPresenter
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApiModul::class, NetworkModul::class])
interface AppComponent {

    fun inject(mainActivityModel: MainActivityModel)

    fun inject(mainActivity: MainActivity)

    fun inject(mainActivityPresenter: MainActivityPresenter)

}