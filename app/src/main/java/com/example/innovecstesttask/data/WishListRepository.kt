package com.example.innovecstesttask.data

import com.example.innovecstesttask.data.retrofit.RetrofitInstance

class WishListRepository {

    private val api = RetrofitInstance.api

    suspend fun getWishlist(): List<WishItemEntity> {
        return api.getWishlist()
    }

    suspend fun getWishlistItem(id: String): WishItemEntity {
        return api.getWishlistItem(id)
    }
}