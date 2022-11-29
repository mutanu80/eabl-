package com.example.eabl.ExistingUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentMemberAccountFoundBinding
import com.example.eabl.databinding.FragmentPasswrdCreationSuccessBinding


class passwrdCreationSuccessFragment : Fragment(R.layout.fragment_passwrd_creation_success) {


    private lateinit var binding: FragmentPasswrdCreationSuccessBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View{
        binding = FragmentPasswrdCreationSuccessBinding.inflate(layoutInflater)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dismissButton.setOnClickListener {

            it.findNavController()
                .navigate(R.id.action_passwrdCreationSuccessFragment_to_chooseProfileFragment2)


        }
    }


}

