package com.geekbrains.moviefinder.Repository

import com.geekbrains.moviefinder.Repository.Model.Movie

interface Repository {
    fun getMovieFromServer(): ArrayList<Movie>
}