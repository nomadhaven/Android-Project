package com.example.housekeepingbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val insertBtn = findViewById<Button>(R.id.insertBtn)
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        val timeSearchBtn = findViewById<Button>(R.id.timeSearchBtn)


        insertBtn.setOnClickListener {
            val intent = Intent(this, InsertActivity::class.java)
            startActivity(intent)
        }

        searchBtn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        timeSearchBtn.setOnClickListener {
            val intent = Intent(this, FindTimeActivity::class.java)
            startActivity(intent)

        }


    }

}