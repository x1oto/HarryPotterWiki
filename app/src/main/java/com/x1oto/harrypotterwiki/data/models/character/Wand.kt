package com.x1oto.harrypotterwiki.data.models.character

import android.os.Parcel
import android.os.Parcelable

data class Wand(
    val core: String,
    val length: Double,
    val wood: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        core = parcel.readString() ?: "",
        length = parcel.readDouble(),
        wood = parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(core)
        parcel.writeDouble(length)
        parcel.writeString(wood)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Wand> {
        override fun createFromParcel(parcel: Parcel): Wand {
            return Wand(parcel)
        }

        override fun newArray(size: Int): Array<Wand?> {
            return arrayOfNulls(size)
        }
    }
}
