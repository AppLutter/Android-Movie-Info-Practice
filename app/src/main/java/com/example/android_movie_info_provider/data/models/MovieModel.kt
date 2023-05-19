package com.example.android_movie_info_provider.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieModel(
    @Json(name = "boxOfficeResult")
    val boxOfficeResult: BoxOfficeResult
)