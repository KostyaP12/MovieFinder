package com.geekbrains.moviefinder.Repository

import com.geekbrains.moviefinder.Repository.Model.Movie

sealed class AppState {
    data class Success(val movieData: Movie) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}