package com.x1oto.harrypotterwiki.data.models.spell

import android.os.Parcel
import android.os.Parcelable

data class SpellItem(
    val description: String,
    val id: String,
    val name: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        description = parcel.readString() ?: "",
        id = parcel.readString() ?: "",
        name = parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeString(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<SpellItem> {
        override fun createFromParcel(parcel: Parcel): SpellItem {
            return SpellItem(parcel)
        }

        override fun newArray(size: Int): Array<SpellItem?> {
            return arrayOfNulls(size)
        }
    }
}
