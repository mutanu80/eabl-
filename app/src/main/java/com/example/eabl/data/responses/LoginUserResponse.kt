package com.example.eabl.data.responses


import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("statusMsg")
    val statusMsg: String,
    @SerializedName("token")
    val token: String
)