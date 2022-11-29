package com.example.eabl.ui.view.newUser

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

        return _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.buttonMember.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_lookUpFragment_to_existingMemberFragment)



        }
        _binding.buttonNewMember.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_lookUpFragment_to_createYourAccountFragment)
        }
    }



}


