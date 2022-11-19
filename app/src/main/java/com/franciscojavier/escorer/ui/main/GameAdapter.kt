package com.franciscojavier.escorer.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.ViewGameBinding
import com.franciscojavier.escorer.dto.GamesResult
import com.franciscojavier.escorer.dto.GamesResultItem


class GameAdapter (
    var gameList : List<GamesResultItem>,
    val listener: (GamesResultItem) -> Unit
): RecyclerView.Adapter<GameAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ViewGameBinding.bind(view)
        fun bind(game: GamesResultItem){
            binding.gameName.text = game.name
            binding.gameSlug.text = game.slug
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_game, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(gameList[position])
        holder.itemView.setOnClickListener{
            listener(gameList[position])
        }
    }

    override fun getItemCount(): Int = gameList.size
}