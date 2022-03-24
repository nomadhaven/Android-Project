package com.example.mydocument

data class DocumentDto(var seq:Int, var imagePath:String, var location:String, var content:String, var date:String){
    override fun toString(): String {
        return "$seq $imagePath $location $content $date"
    }
}