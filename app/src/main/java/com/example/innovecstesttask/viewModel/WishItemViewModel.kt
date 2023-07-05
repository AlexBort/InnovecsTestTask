package com.example.innovecstesttask.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innovecstesttask.data.WishListRepository
import com.example.innovecstesttask.useCase.GetListItemUseCase
import com.example.innovecstesttask.useCase.WishItem
import kotlinx.coroutines.launch

class WishItemViewModel() : ViewModel() {

    private val getWishlistItemUseCase: GetListItemUseCase = GetListItemUseCase(WishListRepository())

    private val _wishlistItem = MutableLiveData<WishItem>()
    val wishItem: LiveData<WishItem> = _wishlistItem

    fun fetchWishlistItem(id: String) {
        viewModelScope.launch {
            val domainItem = getWishlistItemUseCase(id)
            _wishlistItem.value = domainItem
        }
    }
}
