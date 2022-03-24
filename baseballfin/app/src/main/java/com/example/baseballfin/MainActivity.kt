package com.example.baseballfin

import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var baseball:Baseball? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSpinner(R.id.spinner1)
        setupSpinner(R.id.spinner2)
        setupSpinner(R.id.spinner3)

        baseball = Baseball()
        baseball!!.random()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            action()
        }


        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener{
                replay()
        }


    }

    fun action(){
        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinner3 = findViewById<Spinner>(R.id.spinner3)

        val num1 = spinner1.selectedItem.toString().toInt()
        val num2 = spinner2.selectedItem.toString().toInt()
        val num3 = spinner3.selectedItem.toString().toInt()

        var spinnerArr =  arrayOf<Int>(num1, num2, num3)

        val result: MyResult? = baseball?.finding(spinnerArr)

        val textView = findViewById<TextView>(R.id.textView)

        if(result!=null){

            if(result.strike==3){
                baseball?.clear = true
                textView.text =baseball?.resultString()
            }
            else{

                textView.text = "${result.strike} 스트라이크 ${result.ball} 볼입니다."
            }
        }

    }

    fun replay(){

        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinner3 = findViewById<Spinner>(R.id.spinner3)

        spinner1.setSelection(0,false);
        spinner2.setSelection(0,false);
        spinner3.setSelection(0,false);


        baseball?.reset()

        var strike:Int=0
        var ball:Int=0

        val result= MyResult(strike,ball)
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "${result?.strike} 스트라이크 ${result?.ball} 볼입니다."


    }


    //spinner
    fun setupSpinner(spinnerNum:Int){
        var countArr = arrayOf(1,2,3,4,5,6,7,8,9,10)

        val adapter = ArrayAdapter(this,R.layout.item_spinner,countArr)

        val spinner = findViewById<Spinner>(spinnerNum)
        spinner.adapter = adapter

    }
}