package com.example.innovecstesttask.useCase

data class WishItem(
    val id: String,
    val title: String,
    val image: String,
    val hardcodedImageLink:String = "https://images.unsplash.com/photo-1526336024174-e58f5cdd8e13"
)