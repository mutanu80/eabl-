package com.example.eabl.ui.view.existingMember

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentMemberAccountFoundBinding


class MemberAccountFoundFragment : Fragment(R.layout.fragment_member_account_found) {

    private lateinit var binding: FragmentMemberAccountFoundBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View{

        // Inflate the layout for this fragment
        binding=FragmentMemberAccountFoundBinding.inflate(layoutInflater)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.accountSuccessContinueButton.setOnClickListener {
            binding.progressBar1.visibility=View.VISIBLE
            it.findNavController()
                .navigate(R.id.action_memberAccountFoundFragment_to_firstLoginDeviceVerificationFragment)

        }

    }
}

