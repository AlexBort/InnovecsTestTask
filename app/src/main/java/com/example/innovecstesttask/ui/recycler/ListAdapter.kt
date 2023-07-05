package com.example.innovecstesttask.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.innovecstesttask.R
import com.example.innovecstesttask.useCase.WishItem

class ListAdapter(private val onClick: (WishItem) -> Unit) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var data = listOf<WishItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.findViewById<TextView>(R.id.item_title)
        private val imageView = itemView.findViewById<ImageView>(R.id.item_image)

        fun bind(item: WishItem) {
            textView.text = item.title
            Glide.with(imageView.context).load(item.hardcodedImageLink).into(imageView)
            itemView.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size
}
