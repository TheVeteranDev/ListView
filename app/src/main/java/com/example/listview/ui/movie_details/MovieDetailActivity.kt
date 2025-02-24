package com.example.listview.ui.movie_details

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.listview.R
import com.example.listview.databinding.FragmentMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)

        // Creates the binding to the layout
        // res/layout/fragment_movie_etail.xml
        val binding = FragmentMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the values for the movie passed in the intent
        val title = intent.getStringExtra("title")
        val subTitle = intent.getStringExtra("subTitle")
        val boxArt = intent.getIntExtra("boxArt", 0)

        // Set the values to their respective components
        binding.titleText.text = title
        binding.subtitleText.text = subTitle
        binding.boxArtImage.setImageResource(boxArt)

        // Closes the activity and returns the user to the movies fragment
        val closeButton = findViewById<Button>(R.id.close_button)
        closeButton.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}