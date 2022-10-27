package com.example.eabl.View.ExistingMember

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentMemberAccountFoundBinding
import com.example.eabl.databinding.FragmentMemberCreateNewPasswordBinding

class MemberCreateNewPasswordFragment : Fragment(R.layout.fragment_member_create_new_password) {


    private lateinit var _binding: FragmentMemberCreateNewPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View{
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_member_create_new_password, container, false)

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_member_create_new_password, container, false)

        _binding.continue4Button.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_memberCreateNewPasswordFragment_to_passwrdCreationSuccessFragment)



        }
        return _binding.root


    }


}

