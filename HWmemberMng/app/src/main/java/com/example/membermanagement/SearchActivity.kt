package com.example.membermanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        val editTxtname = findViewById<EditText>(R.id.editTxtname)
        val textViewinfo = findViewById<TextView>(R.id.textViewinfo)
        val findBtn = findViewById<Button>(R.id.findBtn)

        findBtn.setOnClickListener {

            val name = editTxtname.text.toString().trim()
            val dbHelper = DBHelper.getInstance(this,"HWmember.db",)
            val result = dbHelper.search(name)

            textViewinfo.text = result

        }

    }
}