//package com.example.innovecstesttask.viewModel.viewModelFactory
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.innovecstesttask.useCase.GetListItemUseCase
//import com.example.innovecstesttask.useCase.GetListUseCase
//import com.example.innovecstesttask.viewModel.WishItemViewModel
//import com.example.innovecstesttask.viewModel.WishListViewModel
//
//abstract class BaseViewModelFactory: ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return createViewModel() as T
//    }
//
//    protected abstract fun <T : ViewModel> createViewModel(): T
//}
//
//class WishListViewModelFactory(private val getWishlistUseCase: GetListUseCase): BaseViewModelFactory() {
//    override fun <T : ViewModel> createViewModel(): T {
//        return WishListViewModel(getWishlistUseCase) as T
//    }
//}
//
//class WishItemViewModelFactory(private val getWishlistItemUseCase: GetListItemUseCase): BaseViewModelFactory() {
//    override fun <T : ViewModel> createViewModel(): T {
//        return WishItemViewModel(getWishlistItemUseCase) as T
//    }
//}