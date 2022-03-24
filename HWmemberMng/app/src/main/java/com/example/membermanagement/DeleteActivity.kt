package com.example.membermanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DeleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        val editTxtdelname = findViewById<EditText>(R.id.editTxtmodname)
        val textViewinfo_del = findViewById<TextView>(R.id.textViewinfo_mod)
        val findBtn_del = findViewById<Button>(R.id.findBtn_mod)
        val deleteBtn = findViewById<Button>(R.id.mod_Btn)

        findBtn_del.setOnClickListener {

            val name = editTxtdelname.text.toString().trim()
            val dbHelper = DBHelper.getInstance(this,"HWmember.db",)
            val result = dbHelper.search(name)

            textViewinfo_del.text = result
        }

        deleteBtn.setOnClickListener {

            val name = editTxtdelname.text.toString().trim()
            val dbHelper = DBHelper.getInstance(this,"HWmember.db",)
            dbHelper.delete(name)




        }


    }
}