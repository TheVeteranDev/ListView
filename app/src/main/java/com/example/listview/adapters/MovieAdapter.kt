package com.example.listview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.listview.R
import com.example.listview.dataclasses.Movie

/**
 * Movie adapter is uses to handle the individual movie detail for each item in the list view
 */
class MovieAdapter(
    private val context: Context,
    private val movies: List<Movie>
): BaseAdapter()  {
    override fun getCount(): Int {
        return movies.size
    }

    override fun getItem(i: Int): Movie {
        return movies[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(
        i: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        // set the view to the xml layout found at res/layout/list_item_movie.xml
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_movie, parent, false)

        // Set all the component views in the layout
        val titleTextView = view.findViewById<TextView>(R.id.movie_title)
        val subtitleTextView = view.findViewById<TextView>(R.id.movie_subtitle)
        val boxArtImageView = view.findViewById<ImageView>(R.id.movie_box_art)

        // Get the movie in the list by its index
        val movie = getItem(i)

        // Set all the values for the components
        titleTextView.text = movie.getTitle()
        subtitleTextView.text = movie.getSubTitle()
        boxArtImageView.setImageResource(movie.getBoxArtDrawable())

        return view
    }

}