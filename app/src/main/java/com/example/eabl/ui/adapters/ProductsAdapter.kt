package com.example.eabl.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eabl.data.responses.ProductsResponse
import com.example.eabl.databinding.ProductsBinding

class ProductsAdapter:ListAdapter<ProductsResponse.Product,ProductsAdapter.ViewHolder>(myDiffUtil) {
    object myDiffUtil:DiffUtil.ItemCallback<ProductsResponse.Product>() {
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
        return ViewHolder(ProductsBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val products = getItem(position)
        holder.bind(products)

    }


   inner class ViewHolder(private val binding:ProductsBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(products: ProductsResponse.Product?) {
           Glide.with(binding.sparklingWine).load(products?.imgUrl).into(binding.sparklingWine)
           binding.sparklingWine2.text=products?.productName


       }

   }
}

