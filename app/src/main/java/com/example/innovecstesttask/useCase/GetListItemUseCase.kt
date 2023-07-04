package com.example.innovecstesttask.useCase

import com.example.innovecstesttask.data.WishListRepository

class GetListItemUseCase(private val repository: WishListRepository) {
    suspend operator fun invoke(itemId: String): WishItem {
        val item = repository.getWishlistItem(itemId)
        return WishItem(item.id, item.title, item.link)
    }
}