package com.example.innovecstesttask.data

import retrofit2.http.GET
import retrofit2.http.Path

interface WishlistApi {
    @GET("api/wishlist")
    suspend fun getWishlist(): List<WishItemEntity>

    @GET("api/wishlist/{itemId}")
    suspend fun getWishlistItem(@Path("itemId") itemId: String): WishItemEntity
}