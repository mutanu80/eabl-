package com.example.eabl.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eabl.data.remote.ApiService
import com.example.eabl.data.repository.MemberRepo
import com.example.eabl.data.remote.States
import com.example.eabl.data.requests.*
import com.example.eabl.data.responses.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body


class RegisterViewModel() : ViewModel() {

    private val repo: MemberRepo = MemberRepo(ApiService.invoke())

    //Register shared flow instance
    private val registerStateFlow: MutableStateFlow<States<UserRegisterResponse>?> =
        MutableStateFlow<States<UserRegisterResponse>?>(null)
    val _registerStateFlow: StateFlow<States<UserRegisterResponse>?>
        get() = registerStateFlow

    //lOGIN SHARED FLOW
    private val loginStateFlow: MutableStateFlow<States<LoginUserResponse>?> =
        MutableStateFlow<States<LoginUserResponse>?>(null)
    val _loginStateFlow: StateFlow<States<LoginUserResponse>?>
        get() = loginStateFlow

    //checking member state flow
    private val checkStateFlow: MutableStateFlow<States<MemberExistResponse>?> =
        MutableStateFlow<States<MemberExistResponse>?>(null)
    val _checkStateFlow: StateFlow<States<MemberExistResponse>?>
        get() = checkStateFlow

    // reset password state flow
    private val resetStateFlow: MutableStateFlow<States<ResetPasswordResponse>?> =
        MutableStateFlow<States<ResetPasswordResponse>?>(null)
    val _resetStateFlow: StateFlow<States<ResetPasswordResponse>?>
        get() = resetStateFlow

    private val otpStateFlow: MutableStateFlow<States<OtpResponse>?> =
        MutableStateFlow<States<OtpResponse>?>(null)
    val _otpStateFlow: StateFlow<States<OtpResponse>?>
        get() = otpStateFlow

    private val setPasswordStateFlow: MutableStateFlow<States<SetPasswordResponse>?> =
        MutableStateFlow<States<SetPasswordResponse>?>(null)
    val _setPasswordStateFlow: StateFlow<States<SetPasswordResponse>?>
        get() = setPasswordStateFlow

    private val addReviewStateFlow: MutableStateFlow<States<AddReviewResponse>?> =
        MutableStateFlow<States<AddReviewResponse>?>(null)
    val _addReviewStateFlow: StateFlow<States<AddReviewResponse>?>
        get() = _addReviewStateFlow

    private val addCartStateFlow: MutableStateFlow<States<AddToCartResponse>?> =
        MutableStateFlow<States<AddToCartResponse>?>(null)
    val _addCartStateFlow: StateFlow<States<AddToCartResponse>?>
        get() = addCartStateFlow

    private val singleProductsStateFlow: MutableStateFlow<States<SingleProductResponse>?> =
        MutableStateFlow<States<SingleProductResponse>?>(null)
    val _singleProductStateFlow: StateFlow<States<SingleProductResponse>?>
        get() = singleProductsStateFlow

    private val getProductsStateFlow: MutableStateFlow<States<ProductsResponse>?> =
        MutableStateFlow<States<ProductsResponse>?>(null)
    val _getProductsStateFlow: StateFlow<States<ProductsResponse>?>
        get() = getProductsStateFlow



//    private val _mockStateFlow: MutableStateFlow<States<MockApiResponse>?> =
//        MutableStateFlow<States<MockApiResponse>?>(null)
//    val mockStateFlow: StateFlow<States<MockApiResponse>?>
//        get()=_mockStateFlow


//    private var _mockStateFlow: MutableStateFlow<States<MockApiResponse>?> =
//        MutableStateFlow<States<MockApiResponse>?>(null)
//    val mockStateFlow: StateFlow<States<MockApiResponse>?> get() = _mockStateFlow


    fun registerUser(fullNames: String, email: String, ID: String) = viewModelScope.launch {
        registerStateFlow.value = repo.getMember(userRequest = UserRequest(fullNames, email, ID))
    }

    fun signInMember(email: String, password: String) = viewModelScope.launch {
        loginStateFlow.value =
            repo.signInMember(loginUserRequest = LoginUserRequest(email, password))
    }

    fun checkMemberAccount(fullNames: String, ID: String) = viewModelScope.launch {
        checkStateFlow.value =
            repo.checkMember(memberExistRequest = MemberExistRequest(fullNames, ID))
    }

    fun resetPassword(email: String) = viewModelScope.launch {
        resetStateFlow.value =
            repo.userForgotPassword(resetPasswordRequest = ResetPasswordRequest(email))
    }

    fun otp(email: String, otp: String) = viewModelScope.launch {
        otpStateFlow.value = repo.keyOtp(otpRequest = OtpRequest(email, otp))
    }
    fun setUserPassword(email:String, password:String)=viewModelScope.launch{
        setPasswordStateFlow.value =repo.userCreatePassword(setPasswordRequest = SetPasswordRequest(email,password))
    }
    fun viewAllProducts()=viewModelScope.launch {
        getProductsStateFlow.value=repo.getProducts()
    }
    fun viewOneProduct()=viewModelScope.launch{
        singleProductsStateFlow.value=repo.getProduct()
    }
//    fun addItemToCart()=viewModelScope.launch{
//        addCartStateFlow.value=repo.addProductsToCart()
//    }
//    fun addProductReview()=viewModelScope.launch {
//        addReviewStateFlow.value=repo.addProductReview()
//    }

//    fun mockApiRes() = viewModelScope.launch {
//        repo.mockApi().catch { e ->
//            _mockStateFlow.value = States.Error(e)
//        }.collect { data ->
//            _mockStateFlow.value = data
//            Log.e("VIEWMODEL", "${data.data.toString()}")
//        }
//    }

//    fun mockOtp() = viewModelScope.launch {
//        repo.inputOtp().catch { e ->
//            _mockStateFlow.value = States.Error(e)
//        }.collect { data ->
//            _mockStateFlow.value = data

//        }
        }

