package com.example.membermanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ReviseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_revise)

        val editTxtmodname = findViewById<EditText>(R.id.editTxtmodname)
        val findBtn_mod = findViewById<Button>(R.id.findBtn_mod)
        val textViewinfo_mod = findViewById<TextView>(R.id.textViewinfo_mod)
        val editTextmodage = findViewById<EditText>(R.id.editTextmodage)
        val editTextmodAddress = findViewById<EditText>(R.id.editTextmodAddress)
        val editTextmodRelation = findViewById<EditText>(R.id.editTextmodRelation)
        val editTextmodPhone = findViewById<EditText>(R.id.editTextmodPhone)




        val mod_Btn = findViewById<Button>(R.id.mod_Btn)



        findBtn_mod.setOnClickListener {

            val name = editTxtmodname.text.toString().trim()
            val dbHelper = DBHelper.getInstance(this,"HWmember.db",)
            val result = dbHelper.search(name)

            textViewinfo_mod.text = result
        }

        mod_Btn.setOnClickListener {

            val name = editTxtmodname.text.toString().trim()
            val age = editTextmodage.text.toString().toInt()
            val address = editTextmodAddress.text.toString().trim()
            val relationship = editTextmodRelation.text.toString().trim()
            val phone = editTextmodPhone.text.toString().trim()


            val dbHelper = DBHelper.getInstance(this,"HWmember.db",)
                dbHelper.revise(name,age,address,relationship,phone)

            val modInfo = dbHelper.search(name)
            textViewinfo_mod.text = modInfo

        }







    }
}