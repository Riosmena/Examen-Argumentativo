package com.example.kotlin.peliculas.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.peliculas.data.PeliculaRepository
import com.example.kotlin.peliculas.data.network.model.PeliculasObject
import com.example.kotlin.peliculas.domain.PeliculasListRequirement
import com.example.kotlin.peliculas.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val peliculaListRequirement = PeliculasListRequirement()

    val peliculaObjectLiveData = MutableLiveData<PeliculasObject>()

    fun getPopularMovies(){
        viewModelScope.launch(Dispatchers.IO){
            val result: PeliculasObject? = peliculaListRequirement(
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