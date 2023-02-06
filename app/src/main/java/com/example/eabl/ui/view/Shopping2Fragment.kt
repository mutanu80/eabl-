package com.example.eabl.ui.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.eabl.R
import com.example.eabl.databinding.FragmentShopping2Binding
import com.example.eabl.ui.adapters.ProductsAdapter


class Shopping2Fragment : Fragment() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var adapter : ProductsAdapter
    private val sharedPrefFile = "kotlinsharedpreference"
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var _binding: FragmentShopping2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentShopping2Binding.inflate(layoutInflater)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.card.setOnClickListener {
            _binding.progressBar1.visibility=View.VISIBLE
            it.findNavController()
                .navigate(R.id.action_shopping2Fragment_to_filtersFragment)
        }
        _binding.addToCartButton.setOnClickListener {


        }}}
