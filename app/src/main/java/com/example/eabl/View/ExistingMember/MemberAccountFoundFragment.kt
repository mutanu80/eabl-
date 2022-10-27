package com.example.eabl.View.ExistingMember

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentLookUpBinding
import com.example.eabl.databinding.FragmentMemberAccountFoundBinding


class MemberAccountFoundFragment : Fragment(R.layout.fragment_member_account_found) {

    private lateinit var _binding: FragmentMemberAccountFoundBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View{
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_member_account_found, container, false)

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_member_account_found, container, false)

        _binding.continueButton.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_memberAccountFoundFragment_to_deviceVerificationFragment)



        }
        return _binding.root


    }


}

