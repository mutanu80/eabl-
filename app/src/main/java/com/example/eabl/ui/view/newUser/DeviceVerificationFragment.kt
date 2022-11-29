package com.example.eabl.ui.view.newUser

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.eabl.R
import com.example.eabl.data.remote.ApiService
import com.example.eabl.data.remote.States
import com.example.eabl.data.repository.MemberRepo
import com.example.eabl.databinding.FragmentDeviceVerificationBinding
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.util.EablSharedPreferences
import com.example.eabl.util.MEMBER_FULL_NAME
import com.example.eabl.util.MEMBER_ID_NUMBER
import com.example.eabl.util.toast
import kotlinx.coroutines.delay


class DeviceVerificationFragment : Fragment(R.layout.fragment_device_verification) {


    private lateinit var binding: FragmentDeviceVerificationBinding
    private lateinit var eablSharedPreferences: EablSharedPreferences
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var otpViewModel:RegisterViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View {
        //val view = inflater.inflate(R.layout.fragment_device_verification, container, false)
        binding=FragmentDeviceVerificationBinding.inflate(layoutInflater)
        return binding.root

    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)


            lifecycleScope.launchWhenCreated {
                setExpiryCountDownTimer()
                delay(100)
                countDownTimer.start()
            }

            eablSharedPreferences = EablSharedPreferences(requireContext())
            val apiService = ApiService()
            val repo = MemberRepo(apiService)
            val factory = MemberViewModelFactory(repo)

//            binding.deviceVerificationButton.setOnClickListener{
//              findNavController().navigate(R.id.action_deviceVerificationFragment_to_loginToAccountFragment)
//            }
//
//        }}

            otpViewModel =
                ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

            lifecycleScope.launchWhenResumed {
                otpViewModel._otpStateFlow.collect() {
                    when (it) {
                        is States.Success -> {
                            binding.progressBar1.visibility=View.INVISIBLE
                            if(it.data?.statusCode==1){
                                toast("${it.data.statusMsg}")
                                findNavController().navigate(R.id.action_deviceVerificationFragment_to_loginToAccountFragment)
                            }else{
                                toast("${it.data?.statusMsg}")
                            }

                        }
                        is States.Error -> {
                            binding.progressBar1.visibility=View.INVISIBLE
                            toast("${it.throwable!!.message.toString()}")
                        }
                        null->{}
                    }
                }
            }


            binding.deviceVerificationButton.setOnClickListener {
                val otp1 = binding.linearLayoutOtp.text.toString()
                val email = eablSharedPreferences.getEmail()

                if (isValidData()) {
                    binding.progressBar1.visibility = View.VISIBLE
                        otpViewModel.otp(email = email, otp = otp1)
                }
            }}

    private fun isValidData(): Boolean {

            val otp1 = binding.linearLayoutOtp.text.toString()
            val email = eablSharedPreferences.getEmail()

        if (otp1.isEmpty()) {
            toast("fill all the fields")
            return false
        }
        if (otp1.length < 6) {
            toast("fill all the fields")
            return false
        }
        if(otp1.length>8){
            toast("unrecognized code")
            return false
        }
        else {
            return true
        }
    }



    private fun setExpiryCountDownTimer() {
        if (::countDownTimer.isInitialized) {
            countDownTimer.cancel()
        }
        countDownTimer = object : CountDownTimer(81000, 1000) {

            override fun onTick(millisUntilFinished: Long) {

                val secondsDownTimer = "" + millisUntilFinished / 1000 + "s"
                Log.e("VERIFICATION","VERY ${secondsDownTimer}")
//                _binding.codeExpire.text = getString(
//                    R.string.did_not_get_code_resend_in_20_second,
//                    secondsDownTimer.toString()
//                )
                binding.codeExpire.text = secondsDownTimer.toString()
            }

            override fun onFinish() {
                binding.codeExpire.text =
                    resources.getText(R.string.resend_code)
                binding.codeExpire.setOnClickListener {
                    initiateRequestOtp()

                }
            }
        }
    }

    private fun initiateRequestOtp() {
otpViewModel.checkMemberAccount(MEMBER_FULL_NAME, MEMBER_ID_NUMBER)
        countDownTimer.start()
    }
    override fun onPause() {
        super.onPause()
        countDownTimer.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()

        countDownTimer.cancel()
    }
}








