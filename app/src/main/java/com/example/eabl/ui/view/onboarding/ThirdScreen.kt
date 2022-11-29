package com.example.eabl.ui.view.onboarding

import android.content.SharedPreferences
import android.os.Bundle
import android.content.Context
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentThirdScreenBinding
import com.example.eabl.util.EablSharedPreferences


class ThirdScreen : Fragment(R.layout.fragment_third_screen) {

    private lateinit var eablSharedPreferences: EablSharedPreferences
    private lateinit var _binding: FragmentThirdScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_third_screen, container, false)

        // Inflate the layout for this fragment
       // val view = inflater.inflate(R.layout.fragment_third_screen, container, false)




        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        eablSharedPreferences = EablSharedPreferences(requireContext())
        _binding.image3.setOnClickListener {
            eablSharedPreferences.setFirstTimeUser(false)
            it.findNavController()
                .navigate(R.id.action_viewPagerFragment_to_lookUpFragment)
        }


    }
}


