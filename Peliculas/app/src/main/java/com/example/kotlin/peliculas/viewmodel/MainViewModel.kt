package com.example.kotlin.peliculas.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.peliculas.model.PeliculaRepository
import com.example.kotlin.peliculas.model.PeliculasObject
import com.example.kotlin.peliculas.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val peliculaObjectLiveData = MutableLiveData<PeliculasObject>()

    fun getPopularMovies(){
        viewModelScope.launch(Dispatchers.IO){
            val peliculaRepository = PeliculaRepository()
            val result: PeliculasObject? = peliculaRepository.getPopularMovies(
                Constants.APIKEY,
                Constants.PAGE
            )
            Log.d("Salida", result?.page.toString())
            CoroutineScope(Dispatchers.Main).launch {
                peliculaObjectLiveData.postValue(result)
            }
        }
    }
}