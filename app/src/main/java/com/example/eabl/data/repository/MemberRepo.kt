package com.example.eabl.data.repository

import com.example.eabl.data.remote.ApiService
import com.example.eabl.data.requests.*

class MemberRepo(private val apiServe: ApiService): SafeApiCall() {

    suspend fun getMember(userRequest: UserRequest) = safeApiCall {
        apiServe.createUser(userRequest)
    }

    suspend fun signInMember(loginUserRequest: LoginUserRequest) = safeApiCall() {
        apiServe.loginUser(loginUserRequest)
    }

    suspend fun checkMember(memberExistRequest: MemberExistRequest) = safeApiCall {
        apiServe.checkIfMemberAccountExists(memberExistRequest)
    }

    suspend fun getProducts()=safeApiCall {
        apiServe.getAllProducts()
    }
    suspend fun addProductsToCart(addToCartRequest: AddToCartRequest)=safeApiCall {
        apiServe.addToCart(addToCartRequest)
    }
    suspend fun addProductReview(addReviewRequest: AddReviewRequest)=safeApiCall {
        apiServe.addReview(addReviewRequest)
    }
    suspend fun getProduct()=safeApiCall {
        apiServe.getSingleProduct()
    }
    suspend fun getShoppingProducts()=safeApiCall {
        apiServe.getShoppingProducts()
    }
//    suspend fun  mockApi()=apiRequestByResourceStateFlow {
//        apiServe.mockApi()
//    }

//    suspend fun inputOtp() = apiRequestByResourceStateFlow {
//        apiServe.enterOtp()
//  }
   suspend fun keyOtp(otpRequest: OtpRequest)=safeApiCall {
       apiServe.enterOtp(otpRequest)
   }
    suspend fun userCreatePassword(setPasswordRequest: SetPasswordRequest) =
        safeApiCall {
            apiServe.createPassword(setPasswordRequest)
        }

        suspend fun userForgotPassword(resetPasswordRequest: ResetPasswordRequest) = safeApiCall {
            apiServe.forgotPassword(resetPasswordRequest)
        }
//
//    suspend fun userCasualLogin(casualMemberLoginRequest: casualMemberLoginRequest) = safeApiCall {
//        apiServe.casualMemberLogin(casualMemberLoginRequest)
//    }
    }