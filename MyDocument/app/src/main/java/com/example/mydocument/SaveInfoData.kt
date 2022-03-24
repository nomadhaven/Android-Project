package com.example.mydocument

import android.os.Parcel
import android.os.Parcelable

class SaveInfoData(var seq: Int, var imagePath: String?,
                   var location: String?, var content:String?, var date:String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),  //seq
        parcel.readString(), //imagepath
        parcel.readString(), //location
        parcel.readString(), //content
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(seq)
        parcel.writeString(imagePath)
        parcel.writeString(location)
        parcel.writeString(content)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SaveInfoData> {
        override fun createFromParcel(parcel: Parcel): SaveInfoData {
            return SaveInfoData(parcel)
        }

        override fun newArray(size: Int): Array<SaveInfoData?> {
            return arrayOfNulls(size)
        }
    }

}