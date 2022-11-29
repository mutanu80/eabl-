package com.example.eabl.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentChooseProfileBinding


class ChooseProfileFragment : Fragment() {

    private lateinit var binding: FragmentChooseProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentChooseProfileBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardView5.setOnClickListener {
            findNavController()
                .navigate(R.id.action_chooseProfileFragment2_to_newMemberLoginFragment)
        }

        binding.cardView6.setOnClickListener {
            findNavController()
                .navigate(R.id.action_chooseProfileFragment2_to_agentLoginFragment)


//        binding.cardView5.setOnLongClickListener {
//            binding.cardView5.isSelected = !binding.cardView5.isSelected
//            true
//
//        }
//
            binding.cardView6.setOnLongClickListener {
                binding.cardView6.isSelected = !binding.cardView6.isSelected
                true
            }
            binding.profileContinueButton.setOnClickListener {
                if (binding.cardView5.isSelected) {
                    findNavController()
                        .navigate(R.id.action_chooseProfileFragment2_to_newMemberLoginFragment)
                }
                if (binding.cardView6.isSelected) {
                    findNavController()
                        .navigate(R.id.action_chooseProfileFragment2_to_agentLoginFragment)
                }
            }
        }
    }}
