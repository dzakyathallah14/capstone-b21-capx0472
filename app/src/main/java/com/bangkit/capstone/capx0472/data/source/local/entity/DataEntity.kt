package com.bangkit.capstone.capx0472.data.source.local.entity

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataEntity (
    var id: Int,
    var name: String,
    var photo: Bitmap
) : Parcelable