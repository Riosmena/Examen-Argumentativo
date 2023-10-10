package com.example.kotlin.peliculas

class PeliculaRepository() {
    private lateinit var api:PeliculaAPIService

    suspend fun getPopularMovies(apiKey:String, page:Int): PeliculasObject? {
        api = NetworkModuleDI()
        return try{
            api.getPopularMovies(apiKey, page)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}