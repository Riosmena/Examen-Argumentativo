package com.example.kotlin.peliculas

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.peliculas.databinding.ActivityMainBinding


class MainActivity: Activity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : PeliculaAdapter = PeliculaAdapter()
    private lateinit var data:ArrayList<PeliculaBase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        setUpRecyclerView(testData())
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun testData():ArrayList<PeliculaBase>{
        var result = ArrayList<PeliculaBase>()

        result.add(PeliculaBase("The Nun II",""))
        result.add(PeliculaBase("The Equalizer 3",""))
        result.add(PeliculaBase("Sound of Freedom",""))

        return result
    }

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