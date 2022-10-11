package com.example.innovecstesttask.data.repository

import com.example.innovecstesttask.data.fetching.ConfigurationDownloader
import com.example.innovecstesttask.data.result_handling.DataResult


class ActionConfigRepository : Repository<DataResult<List<ActionConfig>>> {

    private val downloader = ConfigurationDownloader()

    override suspend fun fetchDataResult(): DataResult<List<ActionConfig>>? {
        return downloader.connect()
    }

}