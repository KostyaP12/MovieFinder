package com.geekbrains.moviefinder.Repository.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.moviefinder.R
import com.geekbrains.moviefinder.Repository.Model.Movie

class HorizontalRecyclerAdapter():
        RecyclerView.Adapter<HorizontalRecyclerAdapter.MovieViewHolder>(), View.OnClickListener{

    private val movieList = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MovieViewHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_film, parent, false)
        return MovieViewHolder(v)
    }
    fun addItems(movieList: ArrayList<Movie>){
        this.movieList.addAll(movieList)
    }

    fun clearItems() = this.movieList.clear()

    override fun getItemCount() =  movieList.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movieList[position])
    }


    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindMovie(movie: Movie){
            itemView.apply {
                findViewById<ImageView>(R.id.imageMovie).apply {
                setImageResource(R.drawable.poster)
                }
                findViewById<TextView>(R.id.textName).text = movie.original_title
                findViewById<TextView>(R.id.textReleaseDate).text = movie.release_date
            }
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}