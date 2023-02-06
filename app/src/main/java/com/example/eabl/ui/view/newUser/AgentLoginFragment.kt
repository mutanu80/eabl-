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
import com.example.eabl.data.remote.States
import com.example.eabl.data.repository.MemberRepo
import com.example.eabl.databinding.FragmentAgentLoginBinding
import com.example.eabl.databinding.FragmentNewMemberLoginBinding
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.util.toast


class AgentLoginFragment : Fragment() {
    private lateinit var binding: FragmentAgentLoginBinding
    private lateinit var loginViewModel: RegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ):  View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_agent_login, container, false)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginDirection.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_agentLoginFragment_to_createYourAccountFragment)
        }

        binding.forgot.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_agentLoginFragment_to_forgotPasswordFragment)
        }

        val apiService = ApiService.invoke()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)

//        binding.agentLoginButton.setOnClickListener {
//            findNavController().navigate(R.id.action_agentLoginFragment_to_collectNewFragment2)
//        }
//    }}

        loginViewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

        lifecycleScope.launchWhenResumed {
            loginViewModel._loginStateFlow.collect() {
                when (it) {
                    is States.Success -> {
                        //binding.progressBar1.visibility=View.INVISIBLE
                        val userId = it.data
                        it.data.let{}
                        if (it.data?.statusCode==1) {
                            toast("${it.data.statusMsg}")
                            findNavController().navigate(R.id.action_agentLoginFragment_to_collectNewFragment2)
                        } else {
                            //toast("${it.data?.statusMsg}")
                            findNavController().navigate(R.id.action_agentLoginFragment_to_collectNewFragment2)

                        }
                    }

                    is States.Error -> {
                        // binding.progressBar1.visibility=View.INVISIBLE
                       // toast("${it.throwable?.message.toString()}")
                        findNavController().navigate(R.id.action_agentLoginFragment_to_collectNewFragment2)
                    }
                    null->{}
                }
            }
        }



        binding.agentLoginButton.setOnClickListener {
            // binding.progressBar1.visibility=View.VISIBLE
            val email = binding.emailLogin.text.toString()
            val password = binding.passwordTxt.text.toString()

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                toast("Email Required")
            }

            if (password.isEmpty()) {
                toast("Password Required")
            }

                if (password.length <8) {
                    toast("A maximum of eight characters required")

                }
                if(!password.matches(".*[A-Z].*".toRegex()))
                {
                    toast("Must contain 1 Upper-case Character")

                }
                if (!password.matches(".*[0-9].*".toRegex()))
                {
                    toast("password must contain atleast 1 number")

                }
                if(!password.matches(".*[a-z].*".toRegex()))
                {
                    toast("Must contain 1 Lower-case Character")

                }
                if(!password.matches(".*[!@#$%^&=+-_].*".toRegex()))
                {
                    toast("Must contain a special Character")




    } else {
                loginViewModel.signInMember(email = email, password = password)
            }
        }
    }
}
