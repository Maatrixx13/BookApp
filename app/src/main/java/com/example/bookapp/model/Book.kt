package com.example.bookapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Book(

    val id: Long,
    val photoUrl:Int,
    val title: String,
    val author: String,
    val description: String,
)

