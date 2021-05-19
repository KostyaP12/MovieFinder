package com.geekbrains.moviefinder.Repository.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieFull(
        val id: Int,
        val original_title: String,
        val overview: String?,
        val poster_path: Int?,
        val release_date: String,
        val title: String
):Parcelable