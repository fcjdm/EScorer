package com.franciscojavier.escorer.ui.league

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.ViewLeagueBinding
import com.franciscojavier.escorer.dto.league.LeaguesResult
import com.franciscojavier.escorer.inflate
import com.franciscojavier.escorer.loadUrl

class LeagueAdapter (
    var leagueList : List<LeaguesResult>,
    val listener: (LeaguesResult) -> Unit
    ): RecyclerView.Adapter<LeagueAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ViewLeagueBinding.bind(view)
        fun bind(league: LeaguesResult){
            binding.gameName.text = league.videogame?.name
            binding.leagueName.text = league.name
            if(league.imageUrl != "") {
                binding.leagueImage.loadUrl(league.imageUrl)
            }else{
                binding.leagueImage.setImageResource(R.drawable.no_image)
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