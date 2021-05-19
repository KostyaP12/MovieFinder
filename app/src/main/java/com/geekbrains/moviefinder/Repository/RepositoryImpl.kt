package com.geekbrains.moviefinder.Repository

import com.geekbrains.moviefinder.Repository.Model.Movie
import com.geekbrains.moviefinder.Repository.Model.getFilms

class RepositoryImpl:Repository {
    override fun getMovieFromServer(): ArrayList<Movie> {
        return getFilms()
    }
}