package com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.yauheni_shcharbuk.kotlinepamexample.App
import com.example.yauheni_shcharbuk.kotlinepamexample.Constants
import com.example.yauheni_shcharbuk.kotlinepamexample.R
import com.example.yauheni_shcharbuk.kotlinepamexample.pojo.Photo
import com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_item.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainActivityView, RecyclerAdapter.Listener {

    override fun click(title: String, url: String) {
        val intent = Intent(this, Item::class.java)
        intent.putExtra(Constants.INTENT_NAME, title)
        intent.putExtra(Constants.INTENT_URL, url)
        startActivity(intent)
    }

    override fun data(list: List<Photo>) {
        adapter.updateList(list)
    }

    override fun error(error: String) {
        toast(error, this)
    }

    @InjectPresenter
    lateinit var mainActivityPresenter: MainActivityPresenter

    private val adapter = RecyclerAdapter(mutableListOf(), this, this)

    init {
        App.appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start()
    }

    fun start() {
        main_list_recycler_view.layoutManager = GridLayoutManager(this, 3)
        main_list_recycler_view.adapter = adapter

        mainActivityPresenter.getData()
    }

    private fun toast(message: String, context: Context, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, message, duration).show()
    }
}
