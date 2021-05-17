package com.geekbrains.moviefinder.Repository

import com.geekbrains.moviefinder.Repository.Model.Movie

class RepositoryImpl:Repository {
    override fun getMovieFromServer(): Movie {
        return Movie()
    }
}