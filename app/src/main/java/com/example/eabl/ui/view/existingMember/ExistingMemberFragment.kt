package com.example.eabl.ui.view.existingMember

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.trimmedLength
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.eabl.R
import com.example.eabl.data.remote.ApiService
import com.example.eabl.data.remote.States
import com.example.eabl.data.repository.MemberRepo
import com.example.eabl.databinding.FragmentExistingMemberBinding
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.util.EablSharedPreferences
import com.example.eabl.util.MEMBER_FULL_NAME
import com.example.eabl.util.MEMBER_ID_NUMBER
import com.example.eabl.util.toast
import kotlinx.coroutines.launch

class ExistingMemberFragment : Fragment(R.layout.fragment_existing_member) {

    private lateinit var _binding: FragmentExistingMemberBinding

    private lateinit var checkingMemberViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_existing_member, container, false)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiService = ApiService()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)

        checkingMemberViewModel =
            ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

        lifecycleScope.launch {

            Log.e("59LINE","59LOG")
            checkingMemberViewModel._checkStateFlow.collect() {
                when (it) {

                    is States.Success -> {
                        _binding.progressBar1.visibility=View.INVISIBLE
                        if(it.data?.statusCode==1){
                            EablSharedPreferences(requireContext()).saveEmail(it.data!!.appUserDetail.email.toString())
                            toast("${it.data.statusMsg}")
                            findNavController().navigate(R.id.action_existingMemberFragment_to_memberAccountFoundFragment)
                        }else{
                           // toast("${it.data?.statusMsg}")
                            findNavController().navigate(R.id.action_existingMemberFragment_to_memberAccountFoundFragment)
                        }

                    }
                    is States.Error -> {
                        _binding.progressBar1.visibility=View.INVISIBLE
                        toast("${it.throwable?.message.toString()}")
                    }
                    null->{}
                }
            }
        }

        _binding.submitButton.setOnClickListener {

            val fullNames = _binding.fullNameTxt.text.toString()
            val nationalID = _binding.idTxt.text.toString()


            if (fullNames.isEmpty()) {
                _binding.fullNameTxt.error = " Name Required"
                _binding.fullNameTxt.requestFocus()
            } else if (nationalID.isEmpty()) {
                _binding.idTxt.error = "Id Number Required"
                _binding.idTxt.requestFocus()
            }
            else if(nationalID.length<7 || nationalID.length>8)
            {
                toast("input correct id")
                _binding.idTxt.requestFocus()
            } else {
                MEMBER_FULL_NAME=fullNames

                _binding.progressBar1.visibility=View.VISIBLE

               checkingMemberViewModel.checkMemberAccount(fullNames = fullNames, nationalID = nationalID)
            }

        }
    }
}






//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        _binding.fullName
//        _binding.idNumber
//
//        _binding.submitButton.setOnClickListener {
//            val fullNames:String = _binding.fullName.text.toString()
//            val idNumber=_binding.idNumber.text.toString()
//
//            if (fullNames.isEmpty()) {
//                _binding.fullName.error = "Name field is required"
//                _binding.fullName.requestFocus()
//
//            }
//            else if (!idNumber.matches((".*[0-9]*.").toRegex())) {
//                _binding.idNumber.error = "ID required"
//                _binding.idNumber.requestFocus()
//
//            } else if (idNumber.length < 7 || .length > 8) {
//                _binding.idNumber.error = "ID format is wrong "
//                _binding.idNumber.requestFocus()
//
//            }
//            else
//             {
//
//                findNavController().navigate(R.id.action_existingMemberFragment_to_memberAccountFoundFragment)
//
//
//            }
//
//        }
//
//
//    }
//}
//
