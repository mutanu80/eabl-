package com.example.eabl.ui.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.eabl.R

class SecondScreen : Fragment() {

    lateinit var image2: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_second_screen, container, false)
        image2 =view.findViewById(R.id.image2)
        val viewPager=activity?.findViewById<ViewPager2>(R.id.viewPager)
        image2.setOnClickListener {

            viewPager?.currentItem = 2
        }

        return view
    }

}