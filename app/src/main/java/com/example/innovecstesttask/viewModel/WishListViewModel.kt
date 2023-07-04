package com.example.innovecstesttask.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innovecstesttask.useCase.GetListUseCase
import com.example.innovecstesttask.useCase.WishItem
import kotlinx.coroutines.launch

class WishListViewModel(private val getWishlistUseCase: GetListUseCase) : ViewModel() {

    private val _items = MutableLiveData<List<WishItem>>()
    val items: LiveData<List<WishItem>> = _items

    init {
        refreshItems()
    }

    private fun refreshItems() {
        viewModelScope.launch {
            val listItems = getWishlistUseCase()
            _items.value = listItems
        }
    }
}
