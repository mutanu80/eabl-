package com.example.eabl.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentFiltersBinding


class FiltersFragment : Fragment() {


    private lateinit var _binding: FragmentFiltersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding=FragmentFiltersBinding.inflate(layoutInflater)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.submitButton2.setOnClickListener {
            _binding.progressBar1.visibility=View.VISIBLE
            it.findNavController()
                .navigate(R.id.action_filtersFragment_to_reviewsFragment)
        }
    }
}