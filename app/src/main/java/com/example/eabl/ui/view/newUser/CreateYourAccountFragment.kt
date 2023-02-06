package com.example.eabl.ui.view.newUser

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.example.eabl.R
import com.example.eabl.data.remote.ApiService
import com.example.eabl.databinding.FragmentCreateYourAccountBinding
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.data.remote.States
import com.example.eabl.util.toast
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.data.repository.MemberRepo
import com.example.eabl.util.EablSharedPreferences


class CreateYourAccountFragment : Fragment() {
    private lateinit var binding: FragmentCreateYourAccountBinding
    private lateinit var registerViewModel:RegisterViewModel

    //called to instantiate the user interface view

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateYourAccountBinding.inflate(
            inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

//gives subclasses the chance to initialize themselves once the view has been created completely
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiService= ApiService.invoke()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)

// viewModel provider creates viewModels via the provided factory and stores them in the view model store owner.
       registerViewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

         lifecycleScope.launchWhenResumed{
                 registerViewModel?._registerStateFlow?.collect {
                     when (it) {
                         is States.Success -> {
                             binding.progressBar1.visibility=View.INVISIBLE
                             if(it.data?.statusCode==1){

                                 toast("${it.data.statusMsg}")
                                 findNavController().navigate(R.id.action_createYourAccountFragment_to_deviceVerificationFragment)
                             }else{
                                // toast("${it.data?.statusMsg}")
                                 findNavController().navigate(R.id.action_createYourAccountFragment_to_deviceVerificationFragment)
                             }

                         }
                         is States.Error -> {
                             binding.progressBar1.visibility=View.INVISIBLE
                            // toast("${it.throwable?.message.toString()}")
                             findNavController().navigate(R.id.action_createYourAccountFragment_to_deviceVerificationFragment)
                         }
                         null->{}
                 }
             }
         }

        binding.continue2Button.setOnClickListener {
            binding.progressBar1.visibility= View.VISIBLE
        val fullNames = binding.fullNameCreateTxt.text.toString()
        val email = binding.emailAddressCreateTxt.text.toString()
        val ID = binding.idNumberTxt.text.toString()

        if (fullNames.isEmpty()) {
            binding.fullNameCreateTxt.error = "Name field is required"
            binding.fullNameCreateTxt.requestFocus()

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailAddressCreateTxt.error = "Email Required"
            binding.emailAddressCreateTxt.requestFocus()

        } else if (!ID.matches((".*[0-9]*.").toRegex())) {
            binding.idNumberTxt.error = "ID required"
            binding.idNumberTxt.requestFocus()

        } else if (ID.length < 7 || ID.length > 8) {
            binding.idNumberTxt.error = "ID format is wrong "
            binding.idNumberTxt.requestFocus()

        } else {
            EablSharedPreferences(requireContext()).saveEmail(email)
            registerViewModel.registerUser(fullNames=fullNames,email=email, ID=ID)


        }

        }

    }
}





