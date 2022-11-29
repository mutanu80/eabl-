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
import com.example.eabl.databinding.FragmentLoginToAccountBinding
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.util.EablSharedPreferences
import com.example.eabl.util.MEMBER_FULL_NAME
import com.example.eabl.util.MEMBER_ID_NUMBER
import com.example.eabl.util.toast
import kotlinx.coroutines.launch


class LoginToAccountFragment : Fragment(R.layout.fragment_login_to_account) {

    private lateinit var eablSharedPreferences: EablSharedPreferences
    private lateinit var _binding: FragmentLoginToAccountBinding
    private lateinit var loginViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login_to_account, container, false)

        return _binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eablSharedPreferences = EablSharedPreferences(requireContext())
        val apiService = ApiService()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)

        _binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginToAccountFragment_to_memberCreateNewPasswordFragment)
        }
    }}

//        loginViewModel =
//            ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
//
//        lifecycleScope.launch {
//            loginViewModel._loginStateFlow.collect() {
//                when (it) {
//                    is States.Success -> {
//                       _binding.progressBar1.visibility=View.GONE
//                        if (it.data?.statusCode==1) {
//                            toast("${it.data.statusMsg}")
//                            findNavController().navigate(R.id.action_loginToAccountFragment_to_memberCreateNewPasswordFragment)
//                        } else {
//                            toast("${it.data?.statusMsg}")
//
//                        }
//
//                    }
//                    is States.Error -> {
//                         _binding.progressBar1.visibility=View.GONE
//                        toast("${it.throwable?.localizedMessage}")
//                        findNavController().navigate(R.id.action_loginToAccountFragment_to_memberCreateNewPasswordFragment)
//                    }
//                    null -> {}
//                }
//            }
//
//        }
//        _binding.loginButton.setOnClickListener {
//            val email = EablSharedPreferences(requireContext()).getEmail()
//            val password = _binding.edPassword.text.toString()
//
//            if (password.isEmpty()) {
//                toast("password Required")
//            }
//            else {
//                _binding.progressBar1.visibility=View.VISIBLE
//               loginViewModel.signInMember(email = email, password= password)
//            }
//
//        }
//    }
//}










