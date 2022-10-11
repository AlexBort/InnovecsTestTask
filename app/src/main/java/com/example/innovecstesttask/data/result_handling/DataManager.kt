package com.example.innovecstesttask.data.result_handling

interface DataManager<T, D> {
    fun getHandledData(data: T): D
}