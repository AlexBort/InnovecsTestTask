package com.example.innovecstesttask.useCase

import com.example.innovecstesttask.data.WishListRepository


class GetListUseCase(private val repository: WishListRepository) {
    suspend operator fun invoke(): List<WishItem> {
        val items = repository.getWishlist()
        return items.map { WishItem(it.id, it.title, it.link) }
    }
}