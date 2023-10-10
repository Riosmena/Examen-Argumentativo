package com.example.kotlin.peliculas.data.network

import com.example.kotlin.peliculas.data.network.model.PeliculasObject
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PeliculaAPIService {
    //https://api.themoviedb.org/3/movie/popular
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Header("Authorization") apiKey: String,
        @Query("page") page: Int
    ): PeliculasObject
}