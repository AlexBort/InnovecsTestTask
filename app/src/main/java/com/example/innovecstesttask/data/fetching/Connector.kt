package com.example.innovecstesttask.data.fetching

interface Connector<D> {
    val URL: String
    suspend fun connect():D
}