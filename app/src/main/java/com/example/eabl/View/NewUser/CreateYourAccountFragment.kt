package com.example.eabl.View.NewUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.viewModel.AuthenticationListener
import com.example.eabl.viewModel.RegisterViewModel
import com.example.eabl.databinding.FragmentCreateYourAccountBinding


class createYourAccountFragment : Fragment(),AuthenticationListener {


    private lateinit var _binding: FragmentCreateYourAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_your_account,
            container, false)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_create_your_account, container, false)

        _binding.continue2Button.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_createYourAccountFragment_to_deviceVerificationFragment)


        }
        val viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        _binding.viewModel=viewModel
        viewModel.authenticationListener=this

        return _binding.root


    }

    override fun onStarted() {
        Toast.makeText(context, "login success", Toast.LENGTH_SHORT).show()

    }

    override fun onSuccess() {
        Toast.makeText(context, "login success", Toast.LENGTH_SHORT).show()
    }

    override fun onFailure() {
        Toast.makeText(context, "invalid email or password", Toast.LENGTH_SHORT).show()

    }

    override fun onEmailBlank() {
        Toast.makeText(context, "email is required", Toast.LENGTH_SHORT).show()
    }

    override fun onIdBlank() {
        Toast.makeText(context, "Id is required", Toast.LENGTH_SHORT).show()
    }

    override fun onFullNameBlank() {
        Toast.makeText(context, "name is required", Toast.LENGTH_SHORT).show()
    }

    override fun onEmailWrongFormat() {
        Toast.makeText(context, "wrong email format", Toast.LENGTH_SHORT).show()
    }
}

