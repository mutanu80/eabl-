package com.example.eabl.ui.view

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.eabl.R
import com.example.eabl.data.remote.ApiService
import com.example.eabl.data.remote.States
import com.example.eabl.data.repository.MemberRepo
import com.example.eabl.databinding.FragmentReviewsBinding
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.util.toast


class ReviewsFragment : Fragment() {

    private lateinit var binding: FragmentReviewsBinding
    private lateinit var reviewsViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReviewsBinding.inflate(layoutInflater)

//        binding.writeReviewsButton.setOnClickListener {
//            binding.progressBar1.visibility=View.VISIBLE
//            it.findNavController()
//                .navigate(R.id.action_reviewsFragment_to_finishOrderFragment)
//        }


        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiService = ApiService.invoke()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)

// viewModel provider creates viewModels via the provided factory and stores them in the view model store owner.
        reviewsViewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

        lifecycleScope.launchWhenResumed {
            reviewsViewModel._addReviewStateFlow?.collect {
                when (it) {
                    is States.Success -> {
                        binding.progressBar1.visibility = View.INVISIBLE
                        if (it.data?.statusCode == 1) {
                            toast("${it.data.statusMsg}")
                            findNavController().navigate(R.id.action_reviewsFragment_to_finishOrderFragment)
                        } else {
                            //toast("${it.data?.statusMsg}")
                            findNavController().navigate(R.id.action_reviewsFragment_to_finishOrderFragment)
                        }

                    }
                    is States.Error -> {
                        binding.progressBar1.visibility = View.INVISIBLE
                      //  toast("${it.throwable?.message.toString()}")
                        findNavController().navigate(R.id.action_reviewsFragment_to_finishOrderFragment)
                    }
                    null -> {}
                }
            }
        }

        binding.writeReviewsButton.setOnClickListener {
            binding.progressBar1.visibility = View.VISIBLE
            val fullNames = binding.jessica.text.toString()
            val description = binding.good.text.toString()
            val time = binding.month.text.toString()


            if (fullNames.isEmpty()) {
                binding.jessica.error = "Name field is required"

            } else if (fullNames.isEmpty()) {
                toast("enter full name")



               // reviewsViewModel.addProductReview()


            }

        }

    }
}
