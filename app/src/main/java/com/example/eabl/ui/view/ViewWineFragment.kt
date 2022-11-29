package com.example.eabl.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.eabl.R
import com.example.eabl.data.remote.ApiService
import com.example.eabl.data.remote.States
import com.example.eabl.data.repository.MemberRepo
import com.example.eabl.data.responses.ProductsResponse
import com.example.eabl.databinding.FragmentShoppingBinding
import com.example.eabl.databinding.FragmentViewWineBinding
import com.example.eabl.ui.adapters.ProductsAdapter
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.util.toast
import kotlinx.coroutines.launch


class ViewWineFragment : Fragment() {
      private lateinit  var binding:FragmentViewWineBinding
      private lateinit var productsViewModel:RegisterViewModel
      private val productAdapter by lazy { ProductsAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentViewWineBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiService = ApiService()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)

        productsViewModel =
            ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
            fetchProductFromApi()
            buttonClicked()



//        lifecycleScope.launch {
//            productsViewModel._getProductsStateFlow.collect() {
//                when (it) {
//
//                    is States.Success -> {
//                        binding.progressBar1.visibility = View.GONE
//                        if (it.data != null) {
//
//                            findNavController().navigate(R.id.action_viewWineFragment_to_productsRecyclerFragment)
//                        } else {
//                            toast("no products found")
//                        }
//
//                    }
//                    is States.Error -> {
//                        binding.progressBar1.visibility = View.GONE
//                        toast("no products")
//                    }
//                    null -> {}
//                }
//
//            }
//        }

    }
    private fun buttonClicked(){
        binding.viewAllProductsButton.setOnClickListener {
            binding.progressBar1.visibility = View.VISIBLE
            findNavController().navigate(R.id.action_viewWineFragment_to_productsRecyclerFragment)
        }
    }
    private fun fetchProductFromApi() {
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
                        requireActivity().toast("${it.throwable?.message.toString()}")
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
                productAdapter.submitList(products.slice(0..3))
                productAdapter?.notifyDataSetChanged()

                binding.productsRecyclerView.apply {
                    layoutManager = GridLayoutManager(this.context!!,2)
                    adapter = productAdapter
                    setHasFixedSize(true)
                }
            }
    }
}