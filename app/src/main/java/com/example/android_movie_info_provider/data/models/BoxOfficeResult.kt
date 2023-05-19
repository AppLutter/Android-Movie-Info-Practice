package com.example.android_movie_info_provider.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BoxOfficeResult(
    @Json(name = "boxofficeType")
    val boxofficeType: String,
    @Json(name = "dailyBoxOfficeList")
    val dailyBoxOfficeList: List<DailyBoxOffice>,
    @Json(name = "showRange")
    val showRange: String
)