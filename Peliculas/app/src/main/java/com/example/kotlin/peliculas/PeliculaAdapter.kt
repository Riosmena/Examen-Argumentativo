package com.example.kotlin.peliculas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.peliculas.databinding.ItemPeliculaBinding

class PeliculaAdapter: RecyclerView.Adapter<PeliculaViewHolder>() {

    var data:ArrayList<PeliculaBase> = ArrayList()

    fun PeliculaAdapter(basicData : ArrayList<PeliculaBase>){
        this.data = basicData
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val binding = ItemPeliculaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PeliculaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}