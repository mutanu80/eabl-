package com.example.eabl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eabl.data.remote.ApiService
import com.example.eabl.data.remote.States
import com.example.eabl.data.repository.MemberRepo
import com.example.eabl.data.responses.ProductsResponse
import com.example.eabl.databinding.FragmentProductsRecyclerBinding
import com.example.eabl.ui.adapters.ProductsAdapter
import com.example.eabl.ui.viewModel.MemberViewModelFactory

import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.util.toast
import kotlinx.coroutines.launch


class ProductsRecyclerFragment : Fragment() {

    private val productAdapter by lazy { ProductsAdapter() }
    private lateinit var productsViewModel: RegisterViewModel
    private lateinit var binding:FragmentProductsRecyclerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentProductsRecyclerBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiService = ApiService()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)
        productsViewModel =
          ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
productsViewModel.viewAllProducts()
        lifecycleScope.launch {
            productsViewModel?._getProductsStateFlow?.collect {
                when (it) {
                    is States.Success -> {
                       // binding.progressBar1.visibility=View.INVISIBLE
                        if(it.data?.statusCode==1){
                            inflateRecyclerView(it.data!!.products)
                            toast("${it.data.statusMsg}")
                        }else{
                            toast("${it.data?.statusMsg}")
                        }

                    }
                    is States.Error -> {
                       // binding.progressBar1.visibility=View.INVISIBLE
                        toast("${it.throwable?.message.toString()}")
                    }
                    null->{}
                }
            }
        }


    }

    private fun inflateRecyclerView(products: List<ProductsResponse.Product>) {
        if (products.isEmpty()) {
            binding.tvErrorResponse.visibility = View.VISIBLE
            binding.productsRecyclerView.visibility = View.GONE
        } else {
            binding.tvErrorResponse.visibility = View.GONE
            binding.productsRecyclerView.visibility = View.VISIBLE
            productAdapter.submitList(products)
            productAdapter?.notifyDataSetChanged()

            binding.productsRecyclerView.apply {
                layoutManager = GridLayoutManager(this.context!!,2)
                adapter = productAdapter
                setHasFixedSize(true)
            }
        }
    }
}
