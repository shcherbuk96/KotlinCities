package com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_main

import com.example.yauheni_shcharbuk.kotlinepamexample.App
import com.example.yauheni_shcharbuk.kotlinepamexample.api.Api
import com.example.yauheni_shcharbuk.kotlinepamexample.pojo.ListApi
import io.reactivex.Observable
import javax.inject.Inject

class MainActivityModel {

    @Inject
    lateinit var api: Api

    private lateinit var mainCallBack: MainCallBack

    init {
        App.appComponent.inject(this)
    }

    fun setCallBack(presenter: MainActivityPresenter) {
        mainCallBack = presenter
    }

    fun getData() {
        val data: Observable<ListApi> = api.listData()
        mainCallBack.data(data)
    }
}