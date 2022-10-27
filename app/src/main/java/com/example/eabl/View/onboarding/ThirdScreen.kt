package com.example.eabl.View.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentThirdScreenBinding


class ThirdScreen : Fragment(R.layout.fragment_third_screen) {


    private lateinit var _binding: FragmentThirdScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View{
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_third_screen, container, false)

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_third_screen, container, false)

        _binding.image3.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_viewPagerFragment_to_lookUpFragment)



        }
        return _binding.root
    }

}

