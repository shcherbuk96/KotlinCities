package com.example.yauheni_shcharbuk.kotlinepamexample

import android.app.Application
import com.example.yauheni_shcharbuk.kotlinepamexample.di.ApiModul
import com.example.yauheni_shcharbuk.kotlinepamexample.di.AppComponent
import com.example.yauheni_shcharbuk.kotlinepamexample.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        appComponent = DaggerAppComponent.builder()
                .apiModul(ApiModul())
                .build()
    }
}