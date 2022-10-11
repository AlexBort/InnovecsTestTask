package com.example.innovecstesttask.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    const val url = "https://s3-us-west-2.amazonaws.com/"

    val retrofit =
        Retrofit.Builder().
        baseUrl(url).
        addConverterFactory(GsonConverterFactory.create()).
        build()

    val configService = retrofit.create(GetConfigService::class.java)
}