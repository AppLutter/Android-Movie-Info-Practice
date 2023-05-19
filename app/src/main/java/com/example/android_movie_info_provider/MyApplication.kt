package com.example.android_movie_info_provider

import android.app.Application
import com.example.android_movie_info_provider.data.repository.MovieRepository
import com.example.android_movie_info_provider.data.repository.MovieRepositoryImpl

class MyApplication : Application() {
    var movieRepository: MovieRepository = MovieRepositoryImpl()


}