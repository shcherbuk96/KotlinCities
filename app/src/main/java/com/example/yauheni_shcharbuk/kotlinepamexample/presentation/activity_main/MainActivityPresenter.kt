package com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.yauheni_shcharbuk.kotlinepamexample.App
import com.example.yauheni_shcharbuk.kotlinepamexample.pojo.ListApi
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter : MvpPresenter<MainActivityView>(), MainCallBack {

    @Inject
    lateinit var model: MainActivityModel

    init {
        App.appComponent.inject(this)
        model.setCallBack(this)
    }

    fun getData() {
        model.getData()
    }

    override fun data(data: Observable<ListApi>) {
        data
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ListApi> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: ListApi) {
                        viewState.data(t.list)
                    }

                    override fun onError(e: Throwable) {
                        viewState.error(e.toString())
                    }

                })
    }
}