package com.example.yauheni_shcharbuk.kotlinepamexample.api

import com.example.yauheni_shcharbuk.kotlinepamexample.Constants
import com.example.yauheni_shcharbuk.kotlinepamexample.pojo.ListApi
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {
    @GET("upt7z")
    fun listData(): Observable<ListApi>

    companion object {
        fun create(): Api {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Constants.URL)
                    .build()

            return retrofit.create(Api::class.java)
        }
    }
}