package com.example.eabl.data.requests


import com.google.gson.annotations.SerializedName

data class AddReviewRequest(
    @SerializedName("nationalID")
    val nationalID: String,
    @SerializedName("productID")
    val productID: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("story")
    val story: String
)