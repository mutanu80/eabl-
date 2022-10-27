package com.example.eabl.viewModel

import android.util.Patterns
import android.view.View
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {
    var email: String? = null
    var ID: String? = null
    var fullNames: String? = null
    var authenticationListener: AuthenticationListener? = null
    fun continueButtonOnclick(view: View) {

        if (email.isNullOrEmpty() || fullNames.isNullOrEmpty() || (ID?.equals(null) == true)) {
            authenticationListener?.onFailure()
        }

    }
}