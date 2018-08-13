package com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_item

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.yauheni_shcharbuk.kotlinepamexample.Constants
import com.example.yauheni_shcharbuk.kotlinepamexample.R
import kotlinx.android.synthetic.main.activity_item.*

class Item : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        title = intent.getStringExtra(Constants.INTENT_NAME)

        item_name.text = intent.getStringExtra(Constants.INTENT_NAME)

        Glide
                .with(this)
                .load(intent.getStringExtra(Constants.INTENT_URL))
                .into(item_image)
    }

}