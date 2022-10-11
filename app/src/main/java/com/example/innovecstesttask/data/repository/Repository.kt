package com.example.innovecstesttask.data.repository

interface Repository<T> {
    suspend fun fetchDataResult(): T?
}