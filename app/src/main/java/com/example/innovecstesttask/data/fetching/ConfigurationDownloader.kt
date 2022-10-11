package com.example.innovecstesttask.data.fetching

import com.example.innovecstesttask.data.result_handling.DataResult
import com.example.innovecstesttask.data.result_handling.ErrorDataResult
import com.example.innovecstesttask.data.result_handling.SuccessDataResult
import com.example.innovecstesttask.data.repository.ActionConfig
import com.example.innovecstesttask.data.retrofit.RetrofitBuilder

class ConfigurationDownloader : Connector<DataResult<List<ActionConfig>>> {

    override val URL: String
        get() = "https://s3-us-west-2.amazonaws.com/androidexam/butto_to_action_config.json"

    override suspend fun connect(): DataResult<List<ActionConfig>> {
        RetrofitBuilder.configService.getList(URL).let { response ->
            if (response.isSuccessful) {
                return SuccessDataResult(response.body()!!)
            }
            else {
                return ErrorDataResult(response.errorBody() as Throwable)
            }
        }
    }
}