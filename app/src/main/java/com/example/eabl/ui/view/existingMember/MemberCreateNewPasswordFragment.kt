package com.example.eabl.ui.view.existingMember

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.eabl.R
import com.example.eabl.data.remote.ApiService
import com.example.eabl.data.remote.States
import com.example.eabl.data.repository.MemberRepo
import com.example.eabl.databinding.FragmentDeviceVerificationBinding
import com.example.eabl.databinding.FragmentMemberCreateNewPasswordBinding
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.util.EablSharedPreferences
import com.example.eabl.util.toast

class MemberCreateNewPasswordFragment : Fragment(R.layout.fragment_member_create_new_password) {

    private lateinit var eablSharedPreferences: EablSharedPreferences
    private lateinit var binding: FragmentMemberCreateNewPasswordBinding
    private lateinit var setPasswordViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding=FragmentMemberCreateNewPasswordBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eablSharedPreferences = EablSharedPreferences(requireContext())
        val email = eablSharedPreferences.getEmail()

        val apiService = ApiService.invoke()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)




        setPasswordViewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

        lifecycleScope.launchWhenResumed {
            setPasswordViewModel?._setPasswordStateFlow?.collect {
                when (it) {
                    is States.Success -> {
                    binding.progressBar1.visibility=View.GONE
                    if (it.data?.statusCode == 1) {

                        toast("${it.data.statusMsg}")
                        findNavController().navigate(R.id.action_memberCreateNewPasswordFragment_to_passwrdCreationSuccessFragment)
                    } else {
                        toast("${it.data?.statusMsg}")

                    }}
                is States.Error -> {


                binding.progressBar1.visibility = View.GONE
                toast("${it.throwable?.message.toString()}")

            }
                null->{}
            }
        }
    }

        binding.createPasswordContinueButton.setOnClickListener {


            val pin = binding.newPasswordTxt.text.toString()
            val confirmPin = binding.repeatPasswordTxt.text.toString()
            val email = eablSharedPreferences.getEmail()
            if (isValidFields()) {
                binding.progressBar1.visibility=View.VISIBLE
                setPasswordViewModel.setUserPassword(email=email, password=pin)
            }


    }}
        private fun isValidFields(): Boolean {
            val pin = binding.newPasswordTxt.text.toString()
            val confirmPin = binding.repeatPasswordTxt.text.toString()
            val email = eablSharedPreferences.getEmail()
            if (email!!.isEmpty()) {
                toast("Email not found")
            return false
            }
            if (pin.isEmpty()) {
                binding.newPasswordTxt.error ="pin is empty"
                return false
            }
            if (!pin.trim().contentEquals(confirmPin.trim())) {
                toast("pin does not match")
                return false
            }
            if (pin.length <8) {
                toast("A minimum of eight characters required")
                return false
            }
            if(!pin.matches(".*[A-Z].*".toRegex()))
            {
                toast("Must contain 1 Upper-case Character")
                return false
            }
            if (!pin.matches(".*[0-9].*".toRegex()))
            {
                toast("password must contain atleast 1 number")
                return false
            }
            if(!pin.matches(".*[a-z].*".toRegex()))
            {
                toast("Must contain 1 Lower-case Character")
                return false
            }
            if(!pin.matches(".*[!@#$%^&=+-_].*".toRegex()))
            {
                toast("Must contain a special Character")
                return false

            }

            return true

    }}