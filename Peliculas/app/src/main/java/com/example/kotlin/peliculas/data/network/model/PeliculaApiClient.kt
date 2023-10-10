package com.example.kotlin.peliculas.data.network.model

import com.example.kotlin.peliculas.data.network.NetworkModuleDI
import com.example.kotlin.peliculas.data.network.PeliculaAPIService

class PeliculaApiClient {
    private lateinit var api: PeliculaAPIService
    suspend fun getPopularMovies(apiKey:String, page:Int): com.example.kotlin.peliculas.data.network.model.PeliculasObject? {
        api = NetworkModuleDI()
        return try{
            api.getPopularMovies(apiKey, page)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}