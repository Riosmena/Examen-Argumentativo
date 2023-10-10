package com.example.kotlin.peliculas.data

import com.example.kotlin.peliculas.data.network.NetworkModuleDI
import com.example.kotlin.peliculas.data.network.PeliculaAPIService
import com.example.kotlin.peliculas.data.network.model.PeliculaApiClient
import com.example.kotlin.peliculas.data.network.model.PeliculasObject

class PeliculaRepository() {

    private val apiPelicula = PeliculaApiClient()

    suspend fun getPopularMovies(apiKey:String, page:Int): PeliculasObject? = apiPelicula.getPopularMovies(apiKey, page)

}