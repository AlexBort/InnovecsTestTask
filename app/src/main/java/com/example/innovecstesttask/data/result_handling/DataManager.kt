package com.example.innovecstesttask.data.result_handling

import dagger.hilt.InstallIn

//@InstallIn
interface DataManager<T, D> {
    fun getHandledData(data: T): D
}