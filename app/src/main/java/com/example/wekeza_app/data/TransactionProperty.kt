package com.example.wekeza_app.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TransactionProperty(
    val id: String,
    val amount:Int
): Parcelable