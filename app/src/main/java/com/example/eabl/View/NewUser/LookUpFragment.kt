package com.example.eabl.View.NewUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentLookUpBinding


class LookUpFragment : Fragment(R.layout.fragment_look_up) {


    private lateinit var _binding: FragmentLookUpBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View{
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_look_up, container, false)

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_look_up, container, false)

        _binding.buttonLookUp.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_lookUpFragment_to_existingMemberFragment)



        }
        _binding.buttonLookUp2.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_lookUpFragment_to_createYourAccountFragment)
        }
        return _binding.root


    }



}


