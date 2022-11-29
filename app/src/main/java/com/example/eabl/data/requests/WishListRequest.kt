package com.example.eabl.data.requests


import com.google.gson.annotations.SerializedName

data class WishListRequest(
    @SerializedName("nationalID")
    val nationalID: String
)