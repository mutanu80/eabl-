package com.example.eabl.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eabl.databinding.ActivityMainBinding


class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
     //lateinit var registerViewModel: RegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = DataBindingUtil.setContentView(this, layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


//    //  val dao = MemberDatabase.getInstance(application).memberDAO
//    val repo = MemberRepository()
//    val factory = MemberViewModelFactory(repo)
//
//      binding.lifecycleOwner = this
//       registerViewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
//
//        lifecycleScope.launch
//    {
//        registerViewModel.getMembers().collect {
//        }
//
}
//
//        }
//            when(it){
//                is ApiStates.Error -> {
//                    binding.tvTest.text=it.throwable!!.message
//                }
//                is ApiStates.Loading -> {
//                    binding.tvTest.text="loading"
//                }
//                is ApiStates.Success -> {
//                    binding.tvTest.text=it.data.toString()
//                    toast(it.data.toString())
//                }
//            }
//        }}





