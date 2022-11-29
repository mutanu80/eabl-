package com.example.eabl.data.requests


import com.google.gson.annotations.SerializedName

data class AddToCartRequest(
    @SerializedName("nationalID")
    val nationalID: String,
    @SerializedName("productId")
    val productId: String
)