package com.gustavo.mvvmexample.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import com.gustavo.mvvmexample.R
import com.gustavo.mvvmexample.model.PokemonReponseItem

class PokemonAdapter(private val pokemons: ArrayList<PokemonReponseItem>) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_adapter_pokemon, parent, false)
        )
    }

    override fun getItemCount() = pokemons.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bindPokemon(pokemons[position])
    }


    // Criando ViewHolder
    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mtvIdPokemon = itemView.findViewById<MaterialTextView>(R.id.mtv_id_pokemon)
        val ivPokemonAvatar = itemView.findViewById<ImageView>(R.id.iv_pokemon_avatar)
        val mtvNamePokemon = itemView.findViewById<MaterialTextView>(R.id.mtv_name_pokemon)

        val mcvBadgeOne = itemView.findViewById<MaterialCardView>(R.id.mcv_badge_one)
        val mcvBadgeTwo = itemView.findViewById<MaterialCardView>(R.id.mcv_badge_two)
        val mcvBadgeOneText = itemView.findViewById<MaterialTextView>(R.id.mtv_badge_one_text)
        val mcvBadgeTwoText = itemView.findViewById<MaterialTextView>(R.id.mtv_badge_two_text)


        @SuppressLint("SetTextI18n")
        fun bindPokemon(pokemonReponseItem: PokemonReponseItem) {
            mtvIdPokemon.text = "#${pokemonReponseItem.number}"
            mtvNamePokemon.text = pokemonReponseItem.name
            ivPokemonAvatar.load(pokemonReponseItem.ThumbnailImage)

            when {
                pokemonReponseItem.type.size == 2 -> {
                    mcvBadgeOne.visibility = View.VISIBLE
                    mcvBadgeTwo.visibility = View.VISIBLE
                    mcvBadgeOneText.text = pokemonReponseItem.type.first()
                    mcvBadgeTwoText.text = pokemonReponseItem.type.last()
                }

                pokemonReponseItem.type.size == 1 -> {
                    mcvBadgeOne.visibility = View.VISIBLE
                    mcvBadgeTwo.visibility = View.GONE
                    mcvBadgeOneText.text = pokemonReponseItem.type.first()
                }

                else -> {
                    mcvBadgeOne.visibility = View.GONE
                    mcvBadgeTwo.visibility = View.GONE
                }

            }

        }


    }

}