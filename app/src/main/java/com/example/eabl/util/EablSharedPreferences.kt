package com.example.eabl.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class EablSharedPreferences(context: Context) {

    companion object{
        private const val EMAIL = "email"
        private const val PHONE_NUMBER ="phoneNumber"
        private const val FIRST_TIME="firstTime"

    }


    val applicationContext = context.applicationContext
    private var  preference: SharedPreferences =
        applicationContext.getSharedPreferences(
           "eabl_preferences", Context.MODE_PRIVATE)

    fun saveEmail(email: String) {
        preference!!.edit().putString(EMAIL, email).apply()
    }

    fun getEmail(): String {
        return preference!!.getString(EMAIL, "")!!
    }

    fun savePhoneNumber(phoneNumber: String) {
        preference!!.edit().putString(PHONE_NUMBER, phoneNumber).apply()
    }

    fun getPhoneNumber(): String {
        return preference!!.getString(PHONE_NUMBER, "")!!
    }
    fun setFirstTimeUser(firstTime:Boolean){
        preference!!.edit().putBoolean(FIRST_TIME, firstTime).apply()
    }
    fun getIsFirstTimeUser(): Boolean {
        return preference!!.getBoolean(FIRST_TIME, true)!!
    }
}