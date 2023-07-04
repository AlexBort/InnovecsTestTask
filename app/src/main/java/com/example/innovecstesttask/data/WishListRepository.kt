package com.example.innovecstesttask.data

class WishListRepository(private val api: WishlistApi) {
    suspend fun getWishlist(): List<WishItemEntity> {
        return api.getWishlist()
    }

    suspend fun getWishlistItem(id: String): WishItemEntity {
        return api.getWishlistItem(id)
    }
}