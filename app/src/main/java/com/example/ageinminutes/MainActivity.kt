 package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDatePicker.setOnClickListener{view->
            clickDatePicker(view )
        }
    }

     fun clickDatePicker(view: View){
         val myCalandar=Calendar.getInstance()
         val year= myCalandar.get(Calendar.YEAR)
         val month= myCalandar.get(Calendar.MONTH)
         val day= myCalandar.get(Calendar.DAY_OF_MONTH)


       DatePickerDialog(
           this,
           DatePickerDialog.OnDateSetListener { view, selectedyear, selectedmonth, selecteddayOfMonth ->
               val selectedDate = "$selecteddayOfMonth/${selectedmonth + 1}/$selectedyear"
               tvSelectedDate.text = selectedDate
               val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
               val theDate = sdf.parse(selectedDate)
               val selectedDateInMinutes = theDate!!.time / 60000
               val currentdate = sdf.parse(sdf.format(System.currentTimeMillis()))
               val currentDateinMunites = currentdate!!.time / 6000
               val difference = currentDateinMunites - selectedDateInMinutes
               tvSelectedDateinMinutes.setText(difference.toString())
           },
           year,
           month,
           day
       ).show()
     }
}