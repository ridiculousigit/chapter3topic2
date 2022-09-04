package binar.academy.chapter3topic2

import android.os.Parcel
import android.os.Parcelable

data class HitungParcelable (val dataUmur : String, val dataTinggi :String, val dataBerat : String, val dataIdeal  : String, val dataCategori : String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dataUmur)
        parcel.writeString(dataTinggi)
        parcel.writeString(dataBerat)
        parcel.writeString(dataIdeal)
        parcel.writeString(dataCategori)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HitungParcelable> {
        override fun createFromParcel(parcel: Parcel): HitungParcelable {
            return HitungParcelable(parcel)
        }

        override fun newArray(size: Int): Array<HitungParcelable?> {
            return arrayOfNulls(size)
        }
    }
}