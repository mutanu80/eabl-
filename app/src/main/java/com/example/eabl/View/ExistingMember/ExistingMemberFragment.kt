package com.example.eabl.View.ExistingMember

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentExistingMemberBinding

class ExistingMemberFragment : Fragment(R.layout.fragment_existing_member) {

    private lateinit var _binding: FragmentExistingMemberBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_existing_member, container, false)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_existing_member, container, false)

        _binding.submitButton.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_existingMemberFragment_to_memberAccountFoundFragment)


        }
        return _binding.root


    }
}