package com.example.eabl.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eabl.data.responses.ProductsResponse
import com.example.eabl.databinding.ProductsBinding
import com.example.eabl.databinding.ShoppingBinding

class ShoppingAdapter : ListAdapter<ProductsResponse.Product, ShoppingAdapter.ViewHolder>(myDiffUtil) {
    object myDiffUtil: DiffUtil.ItemCallback<ProductsResponse.Product>() {
        override fun areItemsTheSame(
            oldItem: ProductsResponse.Product,
            newItem: ProductsResponse.Product
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ProductsResponse.Product,
            newItem: ProductsResponse.Product
        ): Boolean {
            return oldItem.productId==newItem.productId
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ShoppingBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shopping = getItem(position)
        holder.bind(shopping)

    }


    inner class ViewHolder(private val binding: ShoppingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(shopping: ProductsResponse.Product?) {
            Glide.with(binding.sWine).load(shopping?.imgUrl).into(binding.sWine)
            binding.sWine3.text=shopping?.productName


        }

    }
}


