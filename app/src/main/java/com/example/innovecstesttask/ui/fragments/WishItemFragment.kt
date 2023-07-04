package com.example.innovecstesttask.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.innovecstesttask.viewModel.WishItemViewModel

class WishItemFragment : Fragment() {

    private val viewModel: WishItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemId = arguments?.getString("itemId") ?: return

        viewModel.fetchWishlistItem(itemId)
        viewModel.wishItem.observe(viewLifecycleOwner, { item ->
            // update UI
        })
    }
}