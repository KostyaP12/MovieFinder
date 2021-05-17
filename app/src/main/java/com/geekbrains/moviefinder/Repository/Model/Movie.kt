package com.geekbrains.moviefinder.Repository.Model

data class Movie(
    val id:Int =  0,
    val original_title: String? = "Заглушка",
    val overview: String? = "Заглушка",
    //val poster_path: String?,
    val release_date: String = "Заглушка",
    val title: String = "Заглушка"
)