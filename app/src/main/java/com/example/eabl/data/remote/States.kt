package com.example.eabl.data.remote

sealed class States<out T>(
    val data:T?=null,
    val throwable: Throwable?=null
){
    class Success<out T>(data:T): States<T>(data)
    class Error(throwable: Throwable?): States<Nothing>(throwable = throwable)

}