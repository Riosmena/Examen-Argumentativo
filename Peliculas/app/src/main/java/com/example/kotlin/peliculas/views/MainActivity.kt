package com.example.kotlin.peliculas.views

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.peliculas.utils.Constants
import com.example.kotlin.peliculas.adapters.PeliculaAdapter
import com.example.kotlin.peliculas.databinding.ActivityMainBinding
import com.example.kotlin.peliculas.model.PeliculaBase
import com.example.kotlin.peliculas.model.PeliculaRepository
import com.example.kotlin.peliculas.model.PeliculasObject
import com.example.kotlin.peliculas.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : PeliculaAdapter = PeliculaAdapter()
    private lateinit var data:ArrayList<PeliculaBase>
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getPopularMovies()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers(){
        viewModel.peliculaObjectLiveData.observe(this){ peliculasObject ->
            setUpRecyclerView(peliculasObject.results)
        }
    }

    private fun getPopularMovies(){
        CoroutineScope(Dispatchers.IO).launch {
            val peliculaRepository = PeliculaRepository()
            val result: PeliculasObject? = peliculaRepository.getPopularMovies(
                Constants.APIKEY,
                Constants.PAGE
            )
            Log.d("Salida", result?.page.toString())
            CoroutineScope(Dispatchers.Main).launch {
                setUpRecyclerView(result?.results!!)
            }
    }}

    private fun setUpRecyclerView(dataForList:ArrayList<PeliculaBase>){
        binding.RVPelicula.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVPelicula.layoutManager = linearLayoutManager
        adapter.PeliculaAdapter(dataForList)
        binding.RVPelicula.adapter = adapter
    }
}