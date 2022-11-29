package com.example.eabl.data.requests


import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("fullNames")
    val fullNames: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("ID")
    val iD: String
)