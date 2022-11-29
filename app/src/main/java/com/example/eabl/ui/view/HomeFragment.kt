package com.example.eabl.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ):  View{
        binding=FragmentHomeBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
       // val view= inflater.inflate(R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.wishList.setOnClickListener {
            binding.progressBar1.visibility=View.VISIBLE
            it.findNavController()
                .navigate(R.id.action_homeFragment_to_wishListFragment)
        }
        binding.category.setOnClickListener {
            binding.progressBar1.visibility=View.VISIBLE
            it.findNavController()
                .navigate(R.id.action_homeFragment_to_viewWineFragment)
        }
        binding.shopping1.setOnClickListener{
            binding.progressBar1.visibility=View.VISIBLE
            it.findNavController()
                .navigate(R.id.action_homeFragment_to_shoppingFragment)
        }
    }

}