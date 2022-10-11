package com.example.innovecstesttask.data.repository

data class ActionConfig(
    val type: String,
    val enabled: Boolean,
    val priority: Int,
    val valid_days: List<Int>,
    val cool_down: Long
): IResponse
