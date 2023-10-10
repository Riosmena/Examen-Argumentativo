package com.example.kotlin.peliculas.model.pelicula

import com.example.kotlin.peliculas.model.pelicula.Result

data class Pelicula(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)