package com.example.baseballfin

class Baseball {

    var randNum: IntArray = IntArray(3)
    var clear: Boolean = false

    constructor() {
        clear = false

    }

    fun random() {

            /*        randNum[0] = (Math.random() * 10).toInt() + 1 //1~10 사이 숫자
            randNum[1] = (Math.random() * 10).toInt() + 1
            randNum[2] = (Math.random() * 10).toInt() + 1

            if(randNum[0]!=randNum[1]
                && randNum[0]!=randNum[2]
                && randNum[1]!=randNum[2])
                break
        }
    }*/
            //switch 0 0 0 0 0  0 0 0 0 0
            var switch = BooleanArray(10)
            for (i in switch.indices){
            switch[i] = false // 스위치가 꺼져있다. 값이 전부 0 으로 세팅
            }

            var w =0
            while(w<3){
            var r = (Math.random() * 10).toInt() //1~9
            if(switch[r]==false){
                switch[r] =true // 특정 숫자가 들어오면 true
                randNum[w] = r + 1 //1~10
            w++
                }
            }

            for(i in randNum.indices){
                println("randNum[$i] = ${randNum[i]}")
            }
        }

        //strike와 ball을 판정하는 부분
        fun finding(userNum:Array<Int>) : MyResult {
            var strike:Int=0
            var ball:Int=0

            //ball 자리는 다른데 숫자가 같다
            for(i in userNum.indices){
                for(j in userNum.indices){
                    if(userNum[i]==randNum[j] && i!=j){
                        ball++
                    }
                }
            }

            //strike 자리도 맞고 숫자도 맞다
            for(i in userNum.indices){
                if(userNum[i]==randNum[i]){
                    strike++
                }
            }

            return MyResult(strike,ball)
        }

    // 결과
    fun resultString(): String{
        return if(clear==true){
            "축하합니다. 게임 클리어."
        }else{
            "다시 도전하시겠습니까?"
        }
    }


    fun reset(){
        clear = false
        random()
    }
}

class MyResult(val strike:Int, val ball:Int)
