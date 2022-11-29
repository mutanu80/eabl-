package com.example.eabl.util

import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment

private fun getMonthString(month: Int): String {
    val result = when (month) {
        0 -> "Jan"
        1 -> "Feb"
        2 -> "Mar"
        3 -> "Apr"
        4 -> "May"
        5 -> "Jun"
        6 -> "Jul"
        7 -> "Aug"
        8 -> "Sept"
        9 -> "Oct"
        10 -> "Nov"
        11 -> "Dec"
        else -> {
            "Apr"
        }
    }
    return result
}