package com.example.listview.ui.movies

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.listview.R
import com.example.listview.adapters.MovieAdapter
import com.example.listview.databinding.FragmentMoviesBinding
import com.example.listview.dataclasses.Movie
import com.example.listview.ui.movie_details.MovieDetailActivity
import com.google.android.material.snackbar.Snackbar

class MoviesFragment : Fragment() {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Never used... yet
        val viewModel =
            ViewModelProvider(this).get(MoviesView::class.java)

        // Creates a binding to the layout for this fragment
        // res/layout/fragment_movies.xml
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Create a list of movies for the list view to use
        val movies = listOf(
            Movie("Star Wars Episode VI: The Empire Strikes Back", "The adventure continues.", R.drawable.empire_strikes_back),
            Movie("Ghostbusters", "Who you gonna call?", R.drawable.ghostbusters),
            Movie("Die Hard", "The christmas movie", R.drawable.diehard),
            Movie("Terminator 2", "Judgement Day", R.drawable.terminator2),
            Movie("Teenage Mutant Ninja Turtles", "Cowabunga!", R.drawable.tmnt),
            Movie("Batman", "Ever dance with the devil in the pale blue light?", R.drawable.batman),
            Movie("Toy Story", "To infinity... and beyond!", R.drawable.toystory),
            Movie("Jurassic Park", "Rawwwwrrrrrr", R.drawable.jurassicpark)
        )

        // Sort the movies alphabetically by title
        val sortedMovies = movies.sortedBy { it.getTitle() }

        // Using an adapter to handle the individual views of each movie in the list
        val adapter = MovieAdapter(requireContext(), sortedMovies)

        // Bind the adapter to the list view
        binding.movieListView.adapter = adapter

        // Create an on click event to send the user to the movie detail activity
        binding.movieListView.setOnItemClickListener { _, _, i, _ ->
            val selectedMovie = sortedMovies[i]

            // Set the values for the intent that are passed to the movie detail activity
            val intent = Intent(requireContext(), MovieDetailActivity::class.java).apply {
                putExtra("title", selectedMovie.getTitle())
                putExtra("subTitle", selectedMovie.getSubTitle())
                putExtra("boxArt", selectedMovie.getBoxArtDrawable())
            }

            // sets a result to return when the user closes the movie detail activity
            startActivityForResult(intent, 100)
        }

        return root
    }

    /**
     * Handles the activity result from the movie detail activity
     * This will display a snackbar letting the user know they returned to the list view
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            Snackbar.make(binding.root, "Returned to the Movies List", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}