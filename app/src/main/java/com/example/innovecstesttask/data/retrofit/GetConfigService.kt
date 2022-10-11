package com.example.innovecstesttask.data.retrofit

import com.example.innovecstesttask.data.repository.ActionConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface GetConfigService {
    @GET
    suspend fun getList(@Url url: String): Response<List<ActionConfig>>
}