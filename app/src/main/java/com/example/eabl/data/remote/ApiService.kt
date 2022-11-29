package com.example.eabl.data.remote

import com.example.eabl.data.requests.*
import com.example.eabl.data.responses.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

//creating user
    @POST("register")
    suspend fun createUser(@Body userRequest: UserRequest):UserRegisterResponse

//signing in user
    @POST("login")
    suspend fun loginUser(@Body loginUserRequest: LoginUserRequest): LoginUserResponse

    //checking if member exists in the database
    @POST("aclookup")
       suspend fun checkIfMemberAccountExists(@Body memberExistRequest: MemberExistRequest): MemberExistResponse

    @POST("setpwd")
    suspend fun createPassword(@Body setPasswordRequest:SetPasswordRequest):SetPasswordResponse

    @POST("resetpwd")
    suspend fun forgotPassword(@Body resetPasswordRequest: ResetPasswordRequest): ResetPasswordResponse

    @POST("confirmotp")
    suspend fun enterOtp(@Body otpRequest: OtpRequest): OtpResponse

    @GET("/products/allproducts")
    suspend fun getAllProducts():ProductsResponse

    @GET("products/product/{id}/")
    suspend fun getSingleProduct():SingleProductResponse

    @POST("products/product/{id}/addreview")
    suspend fun addReview(addReviewRequest:AddReviewRequest):AddReviewResponse

    @POST("eabl/api/user/addwishlist")
    suspend fun addToCart(addToCartRequest: AddToCartRequest):AddToCartResponse



    companion object {
//    const val MOCK_BASE_URL="https://dummy.restapiexample.com/api/v1/"
const val BASE_URL="https://eabl-api-v3.herokuapp.com/eabl/registration/"
        operator fun invoke(): ApiService {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)
//RETROFITS ADOPTS A JAVA INTERFACE TO HTTP CALLS USING ANNOTATIONS WHICH DEFINE HOW REQUESTS ARE MADE
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }



        }

