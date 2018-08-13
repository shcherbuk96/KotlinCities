package com.example.yauheni_shcharbuk.kotlinepamexample.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Photo(
        @SerializedName("id")
        @Expose
        val id: Int,

        @SerializedName("title")
        @Expose
        val title: String,

        @SerializedName("description")
        @Expose
        val description: String,

        @SerializedName("latitude")
        @Expose
        val latitude: Double,

        @SerializedName("longitude")
        @Expose
        val longitude: Double,

        @SerializedName("url")
        @Expose
        val url: String
)