package com.example.android_movie_info_provider.data.api

import com.example.android_movie_info_provider.data.models.MovieModel
import com.example.android_movie_info_provider.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getMovieInfo(
        @Query("key") key: String = Constants.BASE_URL,
        @Query("targetDt") targetDt: String,
    ): MovieModel

}