package com.example.eabl.ui.view

import android.os.Bundle
import android.util.Patterns
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
import com.example.eabl.databinding.FragmentForgotPasswordBinding
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.util.toast


class ForgotPasswordFragment : Fragment() {
 private lateinit var _binding:FragmentForgotPasswordBinding
 private lateinit var forgotPasswordViewModel: RegisterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= DataBindingUtil.inflate(inflater,
            R.layout.fragment_forgot_password, container, false)
        // Inflate the layout for this fragment
       // val view = inflater.inflate(R.layout.fragment_forgot_password, container, false)
        return _binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiService = ApiService.invoke()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)

        forgotPasswordViewModel =
            ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

        lifecycleScope.launchWhenResumed {
            forgotPasswordViewModel?._resetStateFlow?.collect {
                when (it) {
                    is States.Success -> {
                       //binding.progressBar1.visibility=View.GONE
                        if(it.data?.statusCode==1){
                            toast("Reset otp sent to your email")
                            findNavController().navigate(R.id.action_forgotPasswordFragment_to_deviceVerificationFragment)
                        }else{
                            toast("Reset Failed")
                        }

                    }
                    is States.Error -> {
                        //_binding.progressBar1.visibility=View.INVISIBLE
                        toast("Registration Failed")
                    }
                    null->{}
                }
            }
        }
        _binding.resetPasswordButton.setOnClickListener {
           // binding.progressBar1.visibility= View.VISIBLE
            val email = _binding.emailToResetTxt.text.toString()
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                _binding.emailToResetTxt.error = "Email Required"
                _binding.emailToResetTxt.requestFocus()

            } else {
                forgotPasswordViewModel.resetPassword(email=email)


            }
        }
    }
}
