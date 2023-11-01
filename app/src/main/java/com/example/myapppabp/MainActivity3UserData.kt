package com.example.myapppabp

import android.os.Parcel
import android.os.Parcelable

data class MainActivity3UserData(val username: String?, val password: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity3UserData> {
        override fun createFromParcel(parcel: Parcel): MainActivity3UserData {
            return MainActivity3UserData(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity3UserData?> {
            return arrayOfNulls(size)
        }
    }
}


