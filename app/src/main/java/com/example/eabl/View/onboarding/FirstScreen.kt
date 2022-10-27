package com.example.eabl.View.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.eabl.R


class FirstScreen : Fragment() {

lateinit var image1:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_first_screen, container, false)
        image1 =view.findViewById(R.id.image1)
        val viewPager=activity?.findViewById<ViewPager2>(R.id.viewPager)
        viewPager?.currentItem =1

        return view
    }

}