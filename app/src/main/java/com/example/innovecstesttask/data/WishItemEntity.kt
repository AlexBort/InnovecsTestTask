package com.example.innovecstesttask.data

import com.google.gson.annotations.SerializedName

data class WishItemEntity(
    @SerializedName("wishId")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("link")
    val link: String
)
