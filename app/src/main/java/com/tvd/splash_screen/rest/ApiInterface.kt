package com.tvd.splash_screen.rest

import com.tvd.splash_screen.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("movie/top_rated?")
    fun getTopRatedMovies(@Query("api_key") api_key: String): retrofit2.Call<MovieResponse>
}