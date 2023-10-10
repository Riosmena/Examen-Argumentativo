package com.example.kotlin.peliculas.domain

import com.example.kotlin.peliculas.data.PeliculaRepository
import com.example.kotlin.peliculas.data.network.model.PeliculasObject

class PeliculasListRequirement {
    private val repository = PeliculaRepository()

    suspend operator fun invoke(
        apiKey:String,
        page:Int
    ): PeliculasObject? = repository.getPopularMovies(apiKey, page)
}