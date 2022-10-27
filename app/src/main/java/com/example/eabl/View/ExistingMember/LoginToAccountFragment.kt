package com.example.eabl.View.ExistingMember

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentLoginToAccountBinding
import com.example.eabl.databinding.FragmentMemberAccountFoundBinding


class LoginToAccountFragment : Fragment(R.layout.fragment_login_to_account) {


    private lateinit var _binding: FragmentLoginToAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View{
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login_to_account, container, false)

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_login_to_account, container, false)

        _binding.loginButton.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_loginToAccountFragment_to_memberCreateNewPasswordFragment)



        }
        return _binding.root


    }


}

