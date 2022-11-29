package com.example.eabl.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eabl.data.repository.MemberRepo
import java.lang.IllegalArgumentException

class MemberViewModelFactory(private val repo: MemberRepo):ViewModelProvider.Factory {
    @Throws(IllegalArgumentException::class)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel() as T
        }
        throw java.lang.IllegalArgumentException("Unknown View Model Class")
    }
}