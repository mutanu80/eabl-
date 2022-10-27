package com.example.eabl.viewModel

interface AuthenticationListener {

    fun onStarted()
    fun onSuccess()
    fun onFailure()
    fun onEmailBlank()
    fun onIdBlank()
    fun onFullNameBlank()
    fun onEmailWrongFormat()
}