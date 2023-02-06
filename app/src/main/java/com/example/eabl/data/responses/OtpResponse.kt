package com.example.eabl.data.responses


import com.google.gson.annotations.SerializedName

data class OtpResponse(
    @SerializedName("appUserDetail")
    val appUserDetail: AppUserDetail,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("statusMsg")
    val statusMsg: String
) {
    data class AppUserDetail(
        @SerializedName("accountNonExpired")
        val accountNonExpired: Boolean,
        @SerializedName("accountNonLocked")
        val accountNonLocked: Boolean,
        @SerializedName("authorities")
        val authorities: List<Authority>,
        @SerializedName("credentialsNonExpired")
        val credentialsNonExpired: Boolean,
        @SerializedName("email")
        val email: String,
        @SerializedName("enabled")
        val enabled: Boolean,
        @SerializedName("fullNames")
        val fullNames: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("locked")
        val locked: Boolean,
        @SerializedName("nationalID")
        val nationalID: String,
        @SerializedName("orders")
        val orders: Orders,
        @SerializedName("otpEntity")
        val otpEntity: Any,
        @SerializedName("password")
        val password: String,
        @SerializedName("userRoleEnum")
        val userRoleEnum: String,
        @SerializedName("username")
        val username: String
    ) {
        data class Authority(
            @SerializedName("authority")
            val authority: String
        )

        data class Orders(
            @SerializedName("nationalID")
            val nationalID: String,
            @SerializedName("orderId")
            val orderId: String,
            @SerializedName("orders")
            val orders: String,
            @SerializedName("wishList")
            val wishList: String
        )
    }
}