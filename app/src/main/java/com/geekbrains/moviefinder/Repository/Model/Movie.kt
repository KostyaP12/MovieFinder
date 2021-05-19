package com.geekbrains.moviefinder.Repository.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.geekbrains.moviefinder.R

@Parcelize
data class Movie(
        val movieFull: MovieFull = getDefault(),
        val original_title: String? = "Загулшка",
        val overview: String? = "Заглушка",
        val poster_path: Int? = R.drawable.poster,
        val release_date: String = "Заглушка",
        val title: String = "Заглушка"
) : Parcelable

fun getDefault() = MovieFull(1, "Большой Куш", "Фильм",12, "12.01.01", "Большой Куш")

fun getFilms(): ArrayList<Movie>{
    return arrayListOf(
            Movie(MovieFull(1, "Большой Куш", "Фильм",12, "12.01.01", "Большой Куш"))
    )
}