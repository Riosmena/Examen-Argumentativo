package com.example.kotlin.peliculas.model

import com.google.gson.annotations.SerializedName

data class PeliculasObject(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: ArrayList<PeliculaBase>,
)
