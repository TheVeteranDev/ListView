package com.example.listview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listview.databinding.ActivityMainBinding
import com.example.listview.ui.movies.MoviesFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MoviesFragment())
            .commit()
    }
}