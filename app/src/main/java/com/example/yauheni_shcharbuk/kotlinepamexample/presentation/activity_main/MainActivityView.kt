package com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.yauheni_shcharbuk.kotlinepamexample.pojo.Photo

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainActivityView : MvpView {
    fun data(list: List<Photo>)

    fun error(error: String)
}