package com.example.android_movie_info_provider.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.android_movie_info_provider.data.api.RetrofitInstance.movieApi
import com.example.android_movie_info_provider.data.models.MovieModel
import com.example.android_movie_info_provider.databinding.ActivityMainBinding
import com.example.android_movie_info_provider.ui.viewmodel.MovieViewModel
import com.example.android_movie_info_provider.utils.Constants
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieViewModel: MovieViewModel by viewModels { MovieViewModel.Factory }
        binding.movieViewModel = movieViewModel
        binding.lifecycleOwner = this


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                movieViewModel.uiState.collect {
                }
            }
        }
    }
}




