package com.example.googlemapfragment


import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        val mapsFragment = MapsFragment(this)
        fragmentTransaction.add(R.id.content, mapsFragment) // <- 수정됨
        fragmentTransaction.commit()

        val editTextadress = findViewById<EditText>(R.id.editTextadress)
        val editTextlat = findViewById<EditText>(R.id.editTextlat)
        val editTextlong = findViewById<EditText>(R.id.editTextlong)
        val mapBtn = findViewById<Button>(R.id.mapBtn)

        val geocoder: Geocoder = Geocoder(this)

        //위도 경도 초기화
        var latitude:Double = -34.0
        var longitude:Double = 151.0


        //주소를 위도 경도로 바꾸는 버튼
        mapBtn.setOnClickListener {
            var list:List<Address>? = null
            val address = editTextadress.text.toString()

            try {                                   //지역  , 읽을 개수
                list = geocoder.getFromLocationName(address, 10)
            } catch (e: IOException) {
                e.printStackTrace()
                Log.e("test", "입출력 오류 - 서버에서 주소변환시 에러발생")
            }
            if (list != null) {
                if(list!!.isEmpty()){
                    editTextlat.setText("None matched latitude")
                    editTextlong.setText("None matched longitude")
                    //혹은 아래의 코드로 대체가능
                // Toast.makeText(this, "해당되는 주소 정보는 없습니다", Toast.LENGTH_LONG).show()
                }else{
                    editTextlat.setText(list!![0].latitude.toString())
                    editTextlong.setText(list!![0].longitude.toString())

                    latitude = list!![0].latitude
                    longitude = list!![0].longitude

                    // 위도,경도 입력 후 지도
                    mapsFragment.setLocation(latitude, longitude)


                }
            }
        }


    }
}