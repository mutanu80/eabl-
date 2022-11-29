package com.example.eabl.ui.view

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eabl.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CollectNew2Fragment : BottomSheetDialogFragment(){


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collect_new2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun Fragment.setTransparentBackground() {
            val bottomSheet = (requireView().parent as View)
            bottomSheet.apply {
                backgroundTintMode = PorterDuff.Mode.CLEAR
                backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)
                setBackgroundColor(Color.TRANSPARENT)
            }
        }
    }

}