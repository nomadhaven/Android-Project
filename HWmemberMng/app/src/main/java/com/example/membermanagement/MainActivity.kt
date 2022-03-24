package com.example.membermanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBtn = findViewById<Button>(R.id.addBtn)

        val delBtn = findViewById<Button>(R.id.delBtn)

        val searchBtn = findViewById<Button>(R.id.searchBtn)

        val modBtn = findViewById<Button>(R.id.modBtn)

        val printBtn = findViewById<Button>(R.id.printBtn)

        addBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        delBtn.setOnClickListener {
            val intent = Intent(this, DeleteActivity::class.java)
            startActivity(intent)
        }

        searchBtn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        modBtn.setOnClickListener {
            val intent = Intent(this, ReviseActivity::class.java)
            startActivity(intent)
        }

        printBtn.setOnClickListener {
            val intent = Intent(this, AllmemberActivity::class.java)
            startActivity(intent)

        }





    }
}