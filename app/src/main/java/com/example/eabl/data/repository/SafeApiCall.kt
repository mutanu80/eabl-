package com.example.eabl.data.repository

import com.example.eabl.data.remote.States
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

abstract class SafeApiCall {

    suspend fun <T> safeApiCall(apiCall:suspend()->T): States<T> {
        return withContext(Dispatchers.IO){
            try{
                States.Success(apiCall.invoke())
        }
            catch(e:Exception){
              //  States.Error(throwable = Throwable())
                States.Error(throwable = e)
            }
        }
    }

//    fun <T> apiRequestByResourceStateFlow(api: suspend () -> T) = flow {
//        try {
//            //emit(States.Loading)
//            val dataResponse = api.invoke()
//            emit(States.Success(dataResponse))
//        } catch (exception: Exception) {
//            emit(States.Error(exception))
//        }
//    }.flowOn(Dispatchers.IO)
}