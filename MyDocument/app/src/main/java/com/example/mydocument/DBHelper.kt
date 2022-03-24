package com.example.mydocument

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, filename:String): SQLiteOpenHelper(context,filename,null,1) {

    companion object {
        var dbhelper: DBHelper? = null
        fun getInstance(context: Context, filename: String): DBHelper {
            if (dbhelper == null) {
                dbhelper = DBHelper(context, filename)
            }
            return dbhelper!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var sql: String = "CREATE TABLE IF NOT EXISTS localInfo( " +
                "SEQ INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ImagePath STRING, " +
                "Location STRING," +
                "Content STRING, " +
                "Date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL)"

        db?.execSQL(sql)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql: String = "DROP TABLE if exists localInfo"
        db?.execSQL(sql)
        onCreate(db)

    }

    fun insert(dto: SaveInfoData){
        println("데이터 입력 완료")

        var sql = " INSERT INTO localInfo(ImagePath,Location,Content) " +
                " VALUES('${dto.imagePath}','${dto.location}','${dto.content}')"

        var db = this.writableDatabase
        db.execSQL(sql)

        // 확인용
        var query = "SELECT * FROM localInfo"
        var cursor = db.rawQuery(query,null)
        while(cursor.moveToNext()){
            println(cursor.getInt(cursor.getColumnIndex("SEQ")).toString() + " : "
                    + cursor.getString(cursor.getColumnIndex("ImagePath")) + " : "
                    + cursor.getString(cursor.getColumnIndex("Location")) + " : "
                    + cursor.getString(cursor.getColumnIndex("Content")) + " : "
                    + cursor.getString(cursor.getColumnIndex("Date"))
            )
        }

    }

    fun printList(): ArrayList<SaveInfoData>{
        var list = ArrayList<SaveInfoData>()
        val query = " SELECT * FROM localInfo"

        var db = this.writableDatabase
        var cursor = db.rawQuery(query, null)


        while (cursor.moveToNext()) {
            var _seq = cursor.getColumnIndex("SEQ")
            var _imagepath = cursor.getColumnIndex("ImagePath")
            var _location = cursor.getColumnIndex("Location")
            var _content = cursor.getColumnIndex("Content")
            var _date = cursor.getColumnIndex("Date")

            val seq = cursor.getInt(_seq)
            val imagepath = cursor.getString(_imagepath)
            val location = cursor.getString(_location)
            val content = cursor.getString(_content)
            val date = cursor.getString(_date)

            println("$seq : $imagepath: $location : $content")

            list.add(SaveInfoData(seq,imagepath,location,content,date)) //모든 매개변수가 지정되지 않아 에러난다
        }

        cursor.close()

        return list
    }

}

