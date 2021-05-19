package com.geekbrains.moviefinder.Repository.Adapters

import com.geekbrains.moviefinder.Repository.Model.Movie

interface OnItemViewClickListener {
    fun onItemClick(movie: Movie)
}