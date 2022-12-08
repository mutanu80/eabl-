package com.example.eabl.ui.view.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.eabl.R
import com.example.eabl.ui.view.onboarding.ViewPagerFragment
import com.example.eabl.util.EablSharedPreferences


class Splash2 : Fragment() {
    private lateinit var eablSharedPreferences: EablSharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({

                eablSharedPreferences=EablSharedPreferences(requireContext())             // findNavController().navigate(R.id.action_splash2_to_viewPagerFragment)
            if (eablSharedPreferences.getIsFirstTimeUser()){
                findNavController().navigate(R.id.action_splash2_to_viewPagerFragment)

            }else {
                findNavController().navigate(R.id.action_splash2_to_chooseProfileFragment2)
            }
        }, 3000)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash2, container, false)
    }


}
