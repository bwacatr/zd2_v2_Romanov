package com.bignerdranch.android.zd2_v2_romanov_wearos


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.apply


class MovieAdapter1(
    val movies : MutableList<Movie>
) : RecyclerView.Adapter<MovieAdapter1.MovieViewHolder>()
{
    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_data1,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    )
    {

        holder.itemView.findViewById<TextView>(R.id.textViewCard).apply {
            text = movies[position].title
        }

        holder.itemView.findViewById<ImageView>(R.id.ImageViewCard).apply {
            if (movies[position].img != 0) {
                setImageResource(movies[position].img)
            }
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