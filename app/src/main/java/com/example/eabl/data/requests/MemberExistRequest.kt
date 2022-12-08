package com.example.eabl.data.requests


import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("fullNames")
    val fullNames: String,
    @SerializedName("nationalID")
    val nationalID: String
)