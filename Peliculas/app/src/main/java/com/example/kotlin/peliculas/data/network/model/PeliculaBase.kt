package com.example.kotlin.peliculas.model

import com.google.gson.annotations.SerializedName

data class PeliculaBase(
    @SerializedName("title") val title: String,
    @SerializedName("poster_path") val poster_path: String,
)
