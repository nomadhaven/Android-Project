package com.example.bingobingo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val setBtn = findViewById<Button>(R.id.setBtn)
        val startBtn = findViewById<Button>(R.id.startBtn)
        val spinner =findViewById<Spinner>(R.id.spinner)

        setUpSpinnerNumber()


        setBtn.setOnClickListener {
            val pref = getSharedPreferences("pref", MODE_PRIVATE)
            val editor = pref.edit()
            val userNum = spinner.selectedItem.toString().toInt()
            val toast = Toast.makeText(this.applicationContext, "선택값 저장", Toast.LENGTH_SHORT)
            editor.putInt("number",userNum)
            editor.commit()


            if(userNum!=0){
                toast.show()

            }


        }

        startBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val userNum = spinner.selectedItem.toString().toInt()
            val toast = Toast.makeText(this.applicationContext, "0외의 수를 선택하시오.", Toast.LENGTH_SHORT)

            if(userNum!=0){
                startActivity(intent)
            }
           else{
                toast.show()
           }


        }


    }

    fun setUpSpinnerNumber(){
        val number = resources.getStringArray(R.array.number)
        val adapter = ArrayAdapter(this,R.layout.item_spinner,number)
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapter
}

    fun setUpSpinnerHandler(){
        val spinner = findViewById<Spinner>(R.id.spinner)
    }


}
