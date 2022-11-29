package com.example.eabl.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.eabl.R
import com.example.eabl.data.remote.ApiService
import com.example.eabl.data.remote.States
import com.example.eabl.data.repository.MemberRepo
import com.example.eabl.databinding.FragmentAcLookUpLoginBinding
import com.example.eabl.databinding.FragmentLoginToAccountBinding
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.util.EablSharedPreferences
import com.example.eabl.util.toast
import kotlinx.coroutines.launch


class AcLookUpLoginFragment : Fragment() {


    private lateinit var eablSharedPreferences: EablSharedPreferences
    private lateinit var binding: FragmentAcLookUpLoginBinding
    private lateinit var loginViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View{
        binding = FragmentAcLookUpLoginBinding.inflate(layoutInflater)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eablSharedPreferences = EablSharedPreferences(requireContext())
        val apiService = ApiService()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)
        binding.loginButton.setOnClickListener{
            findNavController().navigate(R.id.action_acLookUpLoginFragment_to_memberCreateNewPasswordFragment)
        }

    }}

//        loginViewModel =
//            ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
//
//        lifecycleScope.launch {
//            loginViewModel._loginStateFlow.collect() {
//                when (it) {
//
//                    is States.Success -> {
//                        binding.progressBar1.visibility = View.GONE
//                        if (it.data?.statusCode == 1) {
//                            toast("${it.data.statusMsg}")
//                            findNavController().navigate(R.id.action_acLookUpLoginFragment_to_memberCreateNewPasswordFragment)
//                        } else {
//                            toast("${it.data?.statusMsg}")
//                        }
//
//                    }
//                    is States.Error -> {
//                        binding.progressBar1.visibility=View.GONE
//                        toast("${it.throwable?.message.toString()}")
//                    }
//                    null -> {}
//                }
//            }
//
//        }
//        binding.loginButton.setOnClickListener {
//            val email = EablSharedPreferences(requireContext()).getEmail()
//            val password = binding.edPassword.text.toString()
//
//            if (password.isEmpty()) {
//                toast("password Required")
//            }
//            else {
//                binding.progressBar1.visibility=View.VISIBLE
//                loginViewModel.signInMember(email = email, password= password)
//            }
//
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
