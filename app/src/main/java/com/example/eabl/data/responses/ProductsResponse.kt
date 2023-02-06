package com.example.eabl.data.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ProductsResponse(
    @SerializedName("products")
    val products: List<Product>,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("statusMsg")
    val statusMsg: String
) {
    @Parcelize
    data class Product(
        @SerializedName("description")
        val description: String,
        @SerializedName("imgUrl")
        val imgUrl: String,
        @SerializedName("noOfReviews")
        val noOfReviews: Int,
        @SerializedName("price")
        val price: Int,
        @SerializedName("productId")
        val productId: String,
        @SerializedName("productName")
        val productName: String,
        @SerializedName("rating")
        val rating: Int,
        @SerializedName("reviews")
        val reviews: List<String>?=null
    ) : Parcelable
}