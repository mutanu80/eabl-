package com.example.eabl.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
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
import com.example.eabl.ui.adapters.ShoppingAdapter
import com.example.eabl.ui.viewModel.MemberViewModelFactory
import com.example.eabl.ui.viewModel.RegisterViewModel
import com.example.eabl.util.toast
import kotlinx.coroutines.launch


class ShoppingFragment : Fragment() {


    private lateinit var shoppingViewModel: RegisterViewModel
    private val shoppingAdapter by lazy { ShoppingAdapter() }
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
        val apiService = ApiService()
        val repo = MemberRepo(apiService)
        val factory = MemberViewModelFactory(repo)

        shoppingViewModel =
            ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
        fetchProductFromApi()
        buttonClicked()




    }
    private fun buttonClicked(){
        binding.shoppingDes.setOnClickListener {
            binding.progressBar1.visibility = View.VISIBLE
            findNavController().navigate(R.id.action_shoppingFragment_to_shopping2Fragment)
        }
    }
    private fun fetchProductFromApi() {
        shoppingViewModel.getShoppingProducts()
        lifecycleScope.launch {
            shoppingViewModel?._getShoppingStateFlow?.collect {
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

    private fun inflateRecyclerView(shopping: List<ProductsResponse.Product>) {
        if (shopping.isEmpty()) {
            binding.tvErrorResponse.visibility = View.VISIBLE
            binding.shoppingRecyclerView.visibility = View.GONE
        } else {
            binding.tvErrorResponse.visibility = View.GONE
            binding.shoppingRecyclerView.visibility = View.VISIBLE
            shoppingAdapter.submitList(shopping.slice(0..1))
            shoppingAdapter?.notifyDataSetChanged()

            binding.shoppingRecyclerView.apply {
                layoutManager = GridLayoutManager(this.context!!, 1)
                adapter = shoppingAdapter
                setHasFixedSize(true)
            }

        }
    }

}




//    binding.appB.setOnClickListener {
//            binding.progressBar1.visibility=View.VISIBLE
//            findNavController()
//                .navigate(R.id.action_shoppingFragment_to_shopping2Fragment)
//        }



