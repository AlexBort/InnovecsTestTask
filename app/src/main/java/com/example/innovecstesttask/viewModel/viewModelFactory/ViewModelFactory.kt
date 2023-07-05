package com.example.innovecstesttask.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.innovecstesttask.useCase.GetListUseCase
import com.example.innovecstesttask.viewModel.WishListViewModel

class ViewModelFactory(private val getWishlistUseCase: GetListUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WishListViewModel::class.java)) {
            return WishListViewModel(getWishlistUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
