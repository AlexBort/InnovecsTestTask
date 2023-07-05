package com.example.innovecstesttask.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innovecstesttask.R
import com.example.innovecstesttask.ui.fragments.WishListFragmentDirections
import com.example.innovecstesttask.ui.recycler.ListAdapter
import com.example.innovecstesttask.viewModel.WishListViewModel

class WishListFragment : Fragment(R.layout.fragment_first) {

    private val viewModel: WishListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = ListAdapter { item ->
            val bundle = Bundle().apply {
                putString("itemId", item.id)
            }
            findNavController().navigate(R.id.action_listFragment_to_itemFragment, bundle)
        }



        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            adapter.data = listItems
        }
    }
}
