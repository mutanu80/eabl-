package com.example.eabl.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.eabl.R
import com.example.eabl.databinding.FragmentWishListBinding

class WishListFragment : Fragment(R.layout.fragment_wish_list) {

    private lateinit var binding: FragmentWishListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding=FragmentWishListBinding.inflate(layoutInflater)
        //val view = inflater.inflate(R.layout.fragment_wish_list, container, false)

        // Inflate the layout for this fragment

        return binding.root
    }

}



