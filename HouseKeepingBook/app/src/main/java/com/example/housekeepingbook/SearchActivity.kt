package com.example.housekeepingbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val SearchMenuBtn = findViewById<Button>(R.id.SearchMenuBtn)
        val SearchDataPicker = findViewById<DatePicker>(R.id.SearchDataPicker)
        val resultOutputTxt = findViewById<TextView>(R.id.resultOutputTxt)
        val resultDateTxt = findViewById<TextView>(R.id.resultDateTxt)
        var resultDate = ""

        val SearchSetDateBtn = findViewById<Button>(R.id.SearchSetDateBtn)

        SearchSetDateBtn.setOnClickListener{
            var dpMonth:String = (SearchDataPicker.month + 1).toString()
            var dpDate:String  = (SearchDataPicker.dayOfMonth).toString()

            if(SearchDataPicker.month + 1<10){
                dpMonth= "0"+"$dpMonth"
            }
            if(SearchDataPicker.dayOfMonth<10){
                dpDate = "0"+"$dpDate"
            }


            resultDate  =
                SearchDataPicker.year.toString() + "-" +
                        dpMonth + "-" +
                        dpDate
            println("resultDate:$resultDate ")

            resultDateTxt.text = resultDate


            val dbHelper = DBHelper.getInstance(this,"HKBook.db",)
            val result = dbHelper.search(resultDate)

            resultOutputTxt.movementMethod = ScrollingMovementMethod.getInstance()
            resultOutputTxt.text = result

        }


        SearchMenuBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}