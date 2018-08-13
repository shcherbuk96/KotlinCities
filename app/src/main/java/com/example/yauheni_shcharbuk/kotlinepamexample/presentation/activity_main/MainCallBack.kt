package com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_main

import com.example.yauheni_shcharbuk.kotlinepamexample.pojo.ListApi
import io.reactivex.Observable

interface MainCallBack {
    fun data(data: Observable<ListApi>)
}