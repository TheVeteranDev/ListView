package com.example.listview.ui.movie_details

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.listview.R
import com.example.listview.databinding.FragmentMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)

        val binding = FragmentMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val subTitle = intent.getStringExtra("subTitle")
        val boxArt = intent.getIntExtra("boxArt", 0)

        binding.titleText.text = title
        binding.subtitleText.text = subTitle
        binding.boxArtImage.setImageResource(boxArt)

        val closeButton = findViewById<Button>(R.id.close_button)
        closeButton.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}