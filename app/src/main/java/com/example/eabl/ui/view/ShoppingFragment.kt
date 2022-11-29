package com.example.eabl.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentShoppingBinding


class ShoppingFragment : Fragment() {


    private lateinit var binding: FragmentShoppingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentShoppingBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sWine2.setOnClickListener {
            binding.progressBar1.visibility=View.VISIBLE
            findNavController()
                .navigate(R.id.action_shoppingFragment_to_shopping2Fragment)
        }
    }
}
