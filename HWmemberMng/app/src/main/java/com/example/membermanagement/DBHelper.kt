package com.example.membermanagement

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//Dao ==

class DBHelper(context:Context,filename:String):SQLiteOpenHelper(context,filename,null,1) {

    // Singleton
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
        var sql: String = "CREATE TABLE IF NOT EXISTS HWmember( " +
                "SEQ INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME STRING, " +
                "AGE INTEGER, " +
                "relationship STRING, " +
                "phone STRING, " +
                "ADDRESS STRING ) "

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {


    }

    fun insert(vo: Member) {
        var sql = " INSERT INTO HWmember(name,age,address,relationship,phone) " +
                " VALUES('${vo.name}',${vo.age},'${vo.address}','${vo.relationship}','${vo.phone}')"

        var db = this.writableDatabase
        db.execSQL(sql)

    }

    fun delete(name: String) {
        var sql = " DELETE FROM HWmember WHERE NAME = " +
                "  '${name}' "

        var db = this.writableDatabase
        db.execSQL(sql)

    }

    fun search(name: String): String {
        var sql = " SELECT SEQ, NAME, AGE, ADDRESS, relationship, phone  FROM HWmember WHERE NAME LIKE" +
                "'${name}'"

        var db = this.writableDatabase
        var result = db.rawQuery(sql, null)

        var str: String? = ""

        while (result.moveToNext()) {
            str += " 번호: " + result.getString(result.getColumnIndex("SEQ")) + " \n " +
                    "이름: " + result.getString(result.getColumnIndex("NAME")) + " \n " +
                    "나이: " + result.getString(result.getColumnIndex("AGE")) + " \n " +
                    "관계: " + result.getString(result.getColumnIndex("relationship")) + " \n " +
                    "연락처: " + result.getString(result.getColumnIndex("phone")) + " \n " +
                    "거주지: " + result.getString(result.getColumnIndex("ADDRESS"))
        }

        if(str == ""){
            println("검색된 데이터가 없습니다.")
        }

        return str!!

    }

    fun revise(name: String, age: Int, address: String,relationship:String, phone:String ) {
        var sql = " UPDATE HWmember SET AGE = '${age}' WHERE NAME ='${name}';"

        var db = this.writableDatabase
        db.execSQL(sql)

        var sql2 = " UPDATE HWmember SET ADDRESS = '${address}' WHERE NAME ='${name}';"

        var db2 = this.writableDatabase
        db2.execSQL(sql2)

        var sql3 = " UPDATE HWmember SET relationship = '${relationship}' WHERE NAME ='${name}';"

        var db3 = this.writableDatabase
        db3.execSQL(sql3)

        var sql4 = " UPDATE HWmember SET phone = '${phone}' WHERE NAME ='${name}';"

        var db4 = this.writableDatabase
        db4.execSQL(sql4)

    }

    fun allMember(): String {
        var sql = " SELECT * FROM HWmember"


        var db = this.writableDatabase
        var result = db.rawQuery(sql, null)

        var str: String? = ""

        while (result.moveToNext()) {
            str +=  "_______________________" +" \n " +" \n " +
                    " 번호: " + result.getString(result.getColumnIndex("SEQ")) + " \n " +
                    "이름: " + result.getString(result.getColumnIndex("NAME")) + " \n " +
                    "나이: " + result.getString(result.getColumnIndex("AGE")) + " \n " +
                    "관계: " + result.getString(result.getColumnIndex("relationship")) + " \n " +
                    "전화번호: " + result.getString(result.getColumnIndex("phone")) + " \n " +
                    "거주지: " + result.getString(result.getColumnIndex("ADDRESS")) + " \n "
        }


        return str!!
    }


}
