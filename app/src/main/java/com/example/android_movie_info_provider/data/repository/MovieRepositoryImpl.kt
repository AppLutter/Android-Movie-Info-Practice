package com.example.android_movie_info_provider.data.repository

import com.example.android_movie_info_provider.data.api.RetrofitInstance
import com.example.android_movie_info_provider.data.models.MovieModel

class MovieRepositoryImpl : MovieRepository {
    override suspend fun getMovieInfo(targetDt: String):MovieModel {
        return RetrofitInstance.movieApi.getMovieInfo(targetDt=targetDt)
    }
}