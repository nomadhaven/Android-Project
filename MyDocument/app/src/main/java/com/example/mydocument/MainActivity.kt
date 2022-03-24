package com.example.mydocument

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mainAddBtn = findViewById<Button>(R.id.mainAddBtn)

        mainAddBtn.setOnClickListener {
            val intent = Intent(this, SaveActivity::class.java)
            startActivity(intent)
        }

        val dbHelper = DBHelper.getInstance(this,"localInfo.db",)
        val list = dbHelper.printList()
        // 확인!
        for (i in list.indices){
            println(list[i].toString())
        }


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val mAdapter = CustomAdapter(this,list)
        recyclerView.adapter = mAdapter

        val layout = LinearLayoutManager(this)
        recyclerView.layoutManager=layout //recycler 뷰에 리니어 레이아웃 적용
        recyclerView.setHasFixedSize(true)




    }
}