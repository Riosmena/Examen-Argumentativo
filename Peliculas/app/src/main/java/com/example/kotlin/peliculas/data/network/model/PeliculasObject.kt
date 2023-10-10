package com.example.kotlin.peliculas.data.network.model

import com.example.kotlin.peliculas.model.PeliculaBase
import com.google.gson.annotations.SerializedName

data class PeliculasObject(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: ArrayList<PeliculaBase>,
)
