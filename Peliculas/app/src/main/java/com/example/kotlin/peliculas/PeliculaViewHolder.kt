package com.example.kotlin.peliculas

import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.peliculas.databinding.ItemPeliculaBinding

class PeliculaViewHolder(private val binding: ItemPeliculaBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: PeliculaBase){
        binding.TVTitle.text = item.title
    }
}