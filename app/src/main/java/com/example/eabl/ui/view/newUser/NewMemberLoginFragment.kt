package com.example.eabl.ui.view.newUser

import android.os.Bundle
import android.util.Patterns
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
import com.example.eabl.data.repository.MemberRepo
import com.example.eabl.databinding.FragmentNewMemberLoginBinding
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.data.remote.States
import com.example.eabl.util.toast


class NewMemberLoginFragment : Fragment() {

    private lateinit var _binding: FragmentNewMemberLoginBinding

    private lateinit var loginViewModel:RegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ):  View{
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_member_login, container, false)

        // Inflate the layout for this fragment
              return _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        _binding.loginDirection.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_newMemberLoginFragment_to_createYourAccountFragment)
        }

        _binding.forgot.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_newMemberLoginFragment_to_forgotPasswordFragment)
        }

        val apiService = ApiService.invoke()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)

        _binding.customerLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_newMemberLoginFragment_to_homeFragment)
        }
    }}


//                        loginViewModel=ViewModelProvider(this,factory).get(RegisterViewModel::class.java)
//
//                        lifecycleScope.launchWhenResumed {
//                            loginViewModel._loginStateFlow.collect(){
//                                when (it) {
//
//                                    is States.Error -> { _binding.progressBar1.visibility=View.INVISIBLE
//                        toast("${it.throwable?.message.toString()}")
//                    }
//                    is States.Success -> {
//                        _binding.progressBar1.visibility=View.INVISIBLE
//                        val userId = it.data
//                        it.data.let{}
//                        if (it.data?.statusCode==1) {
//                                toast("${it.data.statusMsg}")
//                            findNavController().navigate(R.id.action_newMemberLoginFragment_to_homeFragment)
//                        } else {
//                            toast("${it.data?.statusMsg}")
//                            findNavController().navigate(R.id.action_memberCreateNewPasswordFragment_to_passwrdCreationSuccessFragment)
//                        }
//                    }
//                    null->{}
//                }
//            }
//            }
//
//        _binding.customerLoginButton.setOnClickListener {
//            _binding.progressBar1.visibility=View.VISIBLE
//
//            val email = _binding.emailLogin.text.toString()
//            val password = _binding.passwordTxt.text.toString()
//
//            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                _binding.emailLogin.error = "Email Required"
//                _binding.emailLogin.requestFocus()
//            } else if(password.isEmpty()) {
//                _binding.passwordTxt.error = "Password Required"
//                _binding.passwordTxt.requestFocus()
//            }
//             else
//                findNavController().navigate(R.id.action_memberCreateNewPasswordFragment_to_passwrdCreationSuccessFragment)
//             //{loginViewModel.signInMember(email = email, password = password)
//            }
//
//        }
//    }
//
