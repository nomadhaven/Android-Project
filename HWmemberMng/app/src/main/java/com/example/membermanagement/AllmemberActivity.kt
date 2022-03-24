package com.example.membermanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView

class AllmemberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allmember)

        val dbHelper = DBHelper.getInstance(this,"HWmember.db",)
        val result = dbHelper.allMember()

        val allmemList = findViewById<TextView>(R.id.allmemList)
        allmemList.movementMethod = ScrollingMovementMethod()
        allmemList.text= result



    }
}