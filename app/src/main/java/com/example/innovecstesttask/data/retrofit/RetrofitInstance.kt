package com.example.innovecstesttask.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val BASE_URL = "http://wishlistwebapp-dev.eba-zw2tds2i.eu-north-1.elasticbeanstalk.com/"


    val api: WishlistApi by lazy {
        Retrofit.Builder().
        baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).
        build().
        create(WishlistApi::class.java)
    }
}