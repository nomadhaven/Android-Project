package com.example.bingobingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        match()

        var restartBtn = findViewById<Button>(R.id.restartBtn)


        restartBtn.setOnClickListener {
            val linerLayout = findViewById<LinearLayout>(R.id.linearLayout)
            linerLayout.removeAllViews()
            match()
        }

    }




    fun match(){

        val pref = getSharedPreferences("pref", MODE_PRIVATE)
        var number:Int = pref.getInt("number",0)

        val linearLayout =  findViewById<LinearLayout>(R.id.linearLayout)

        var childLayout:LinearLayout? = null



        var randomNum = (Math.random() * number).toInt() + 1
        var btnCount = number

        for(i in 0 until btnCount){

            if(i % 3 == 0) { //horizontal layout 3개 만들어서 linearlayout 한칸에 붙인다.

                childLayout = LinearLayout(this)
                childLayout.orientation = LinearLayout.HORIZONTAL
                val layoutParams =
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200) //horizontal layout
                childLayout.layoutParams = layoutParams
            }
            //가로와 세로를 모두 match parent로 매치 레이아웃 만드는 부분
            val btnParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            btnParams.weight = 1.0f

            //버튼 생성 및 버튼 할당하는 부분
            val normalBtn = Button(this).apply {

                text = (i + 1).toString()  //normalBtn.text =(i+1).toString()과 동일
                layoutParams = btnParams //동일한 크기의 버튼 넣어준다.
                id = i //버튼의 아이디가 순서대로 정해진다.


                setOnClickListener{

                    val btn = findViewById<Button>(id)

                    if(randomNum==id+1){
                        btn.text = "BINGO!"
                    }else{
                        btn.text ="SAFE"
                        btn.isEnabled = false
                    }
                }
            }

            childLayout?.addView(normalBtn)

            if(i % 3 == 2 || i == (btnCount-1)){
                linearLayout.addView(childLayout)
            }

        }

    }

}