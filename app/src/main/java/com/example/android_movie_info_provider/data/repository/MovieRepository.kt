package com.example.android_movie_info_provider.data.repository

import com.example.android_movie_info_provider.data.models.MovieModel

interface MovieRepository {

    suspend fun getMovieInfo(
        targetDt: String,
    ): MovieModel
}