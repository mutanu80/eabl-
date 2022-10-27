package com.example.eabl.View.NewUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentCreateYourAccountBinding
import com.example.eabl.databinding.FragmentDeviceVerificationBinding


class DeviceVerificationFragment : Fragment(R.layout.fragment_device_verification) {


    private lateinit var _binding: FragmentDeviceVerificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View{
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_device_verification, container, false)

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_device_verification, container, false)

        _binding.continue5Button.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_deviceVerificationFragment_to_loginToAccountFragment)



        }
        return _binding.root


    }


}

