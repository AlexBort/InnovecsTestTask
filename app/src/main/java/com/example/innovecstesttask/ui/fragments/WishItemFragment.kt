package com.example.innovecstesttask.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.innovecstesttask.R
import com.example.innovecstesttask.viewModel.WishItemViewModel

class WishItemFragment : Fragment(R.layout.fragment_wish_item) {

    private val viewModel: WishItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemId = arguments?.getString("itemId") ?: return

        val imageView = view.findViewById<ImageView>(R.id.image)
        val titleView = view.findViewById<TextView>(R.id.title)
        val idView = view.findViewById<TextView>(R.id.id)

        viewModel.fetchWishlistItem(itemId)
        viewModel.wishItem.observe(viewLifecycleOwner) { item ->
            // update UI
            Glide.with(imageView.context)
                .load(item.hardcodedImageLink)
                .circleCrop() // for rounded image
                .into(imageView)
            titleView.text = item.title
            idView.text = item.id
        }
    }
}
