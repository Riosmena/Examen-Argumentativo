package com.example.kotlin.peliculas.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.peliculas.utils.Constants
import com.example.kotlin.peliculas.model.PeliculaBase
import com.example.kotlin.peliculas.databinding.ItemPeliculaBinding
import com.squareup.picasso.Picasso

class PeliculaViewHolder(private val binding: ItemPeliculaBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: PeliculaBase){
        binding.TVTitle.text = item.title

        val imageUrl = Constants.BASE_IMG_URL + item.poster_path
        Picasso.get().load(imageUrl).into(binding.IVPhoto)
    }
}