package com.example.submisi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val name: String,
    val description: String,
    val photo: String,
    val studio: String,
    val episode: String,
    val aired: String,
    val rating: String,
    val linkMAL: String,
    val linkYT: String
) : Parcelable
