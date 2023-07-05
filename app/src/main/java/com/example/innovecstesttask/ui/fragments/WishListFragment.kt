package com.example.innovecstesttask.ui.fragments

import com.example.innovecstesttask.ui.recycler.ListAdapter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.innovecstesttask.R
import com.example.innovecstesttask.viewModel.WishListViewModel
//import com.example.innovecstesttask.viewModel.viewModelFactory.WishListViewModelFactory

class WishListFragment : Fragment(R.layout.fragment_first) {


    private val viewModel: WishListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListAdapter {
//                val action = WishListFragmentDirections
//            findNavController().navigate(action)
        }

//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        recyclerView.adapter = adapter
//        recyclerView.addItemDecoration(
//            DividerItemDecoration(
//                context,
//                DividerItemDecoration.VERTICAL
//            )
//        )

        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            adapter.data = listItems
        }
    }
}
