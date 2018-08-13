package com.example.yauheni_shcharbuk.kotlinepamexample.pojo

import com.google.gson.annotations.SerializedName

data class ListApi(
        @SerializedName("photos")
        val list: List<Photo>
)