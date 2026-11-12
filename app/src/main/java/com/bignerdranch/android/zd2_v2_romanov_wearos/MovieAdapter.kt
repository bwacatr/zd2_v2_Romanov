package com.bignerdranch.android.zd2_v2_romanov_wearos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.apply


class MovieAdapter(
    val movies : MutableList<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()
{
    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_data,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    )
    {

        holder.itemView.findViewById<TextView>(R.id.title).apply {
            text = movies[position].title
        }




    }



    override fun getItemCount(): Int {
        return movies.size
    }

    fun useList(newBooks: List<Movie>)
    {
        movies.clear()
        newBooks.forEach { movies.add(it) }
        notifyDataSetChanged()
    }
}