package com.example.eabl.ui.view

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.text.format.DateUtils.getMonthString
import android.util.MonthDisplayHelper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.eabl.R
import com.example.eabl.databinding.FragmentCollectNewBinding
import java.text.SimpleDateFormat
import java.time.Year
import java.time.YearMonth
import java.util.*

class CollectNewFragment : Fragment() {

    private lateinit var binding: FragmentCollectNewBinding
    private lateinit var tvDateOfCollection:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

binding=FragmentCollectNewBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_collect_new, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addDetailsFloatingButton.setOnClickListener {
            findNavController()
                .navigate(R.id.action_collectNewFragment2_to_collectNew2Fragment2)
        }
            tvDateOfCollection= binding.dateOfCollection
        
        val myCalendar=Calendar.getInstance()
        val datePicker=DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
        
        myCalendar.set(Calendar.YEAR,year)
        myCalendar.set(Calendar.MONTH,month)
        myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth) 
        updateLabel(myCalendar)    
        }
tvDateOfCollection.setOnClickListener{
    DatePickerDialog(requireContext(),datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),
        myCalendar.get(Calendar.DAY_OF_MONTH)).show()
}


    }

    private fun updateLabel(myCalendar: Calendar) {
val myFormat="dd-MM-yyyy"
        val sdf=SimpleDateFormat(myFormat, Locale.UK)
        tvDateOfCollection.setText(sdf.format(myCalendar.time))
    }
}