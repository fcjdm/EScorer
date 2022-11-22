package com.franciscojavier.escorer.ui.league

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.ViewLeagueBinding
import com.franciscojavier.escorer.dto.league.LeaguesResultItem
import com.franciscojavier.escorer.inflate
import com.franciscojavier.escorer.loadUrl

class LeagueAdapter (
    var leagueList : List<LeaguesResultItem>,
    val listener: (LeaguesResultItem) -> Unit
    ): RecyclerView.Adapter<LeagueAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ViewLeagueBinding.bind(view)
        fun bind(league: LeaguesResultItem){
            binding.gameName.text = league.videogame.name
            binding.leagueName.text = league.name
            if(league.imageUrl!=null) {
                binding.leagueImage.loadUrl(league.imageUrl)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_league, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(leagueList[position])
        holder.itemView.setOnClickListener{
            listener(leagueList[position])
        }
    }

    override fun getItemCount(): Int = leagueList.size
}