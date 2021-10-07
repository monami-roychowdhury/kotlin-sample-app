package com.example.sampleapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val body: String,
    val id: Int,
    val title: String,
    val user_id: Int
) : Parcelable