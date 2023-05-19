package com.example.android_movie_info_provider.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.android_movie_info_provider.data.api.RetrofitInstance.movieApi
import com.example.android_movie_info_provider.data.models.MovieModel
import com.example.android_movie_info_provider.databinding.ActivityMainBinding
import com.example.android_movie_info_provider.ui.viewmodel.MovieStatus
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


        val movieLoadingView = binding.movieLoadingView;
        val movieListView = binding.movieListView;
        val movieErrorView = binding.movieErrorView;

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                movieViewModel.uiState.collect { state ->
                    when (state.status) {
                        MovieStatus.LOADING -> {
                            movieLoadingView.visibility = View.VISIBLE;
                            movieListView.visibility = View.GONE;
                            movieErrorView.visibility = View.GONE
                        }

                        MovieStatus.SUCCESS -> {
                            movieLoadingView.visibility = View.GONE;
                            movieListView.visibility = View.VISIBLE;
                            movieErrorView.visibility = View.GONE
                        }

                        MovieStatus.ERROR -> {
                            movieLoadingView.visibility = View.GONE;
                            movieListView.visibility = View.GONE;
                            movieErrorView.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }
}




