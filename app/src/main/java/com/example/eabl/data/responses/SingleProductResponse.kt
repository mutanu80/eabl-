package com.example.eabl.data.responses


import com.google.gson.annotations.SerializedName

data class SingleProductResponse(
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
    val reviews: List<Review>
) {
    data class Review(
        @SerializedName("date")
        val date: String,
        @SerializedName("nationalID")
        val nationalID: String,
        @SerializedName("productID")
        val productID: String,
        @SerializedName("rating")
        val rating: Double,
        @SerializedName("reviewId")
        val reviewId: String,
        @SerializedName("story")
        val story: String
    )
}