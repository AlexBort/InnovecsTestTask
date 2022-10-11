package com.example.innovecstesttask.data.result_handling

sealed class DataResult<T>

class SuccessDataResult<T>(val data: T) : DataResult<T>()

class ErrorDataResult<T>(val throwable: Throwable) : DataResult<T>()