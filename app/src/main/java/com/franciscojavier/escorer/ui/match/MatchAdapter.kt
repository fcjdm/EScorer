package com.franciscojavier.escorer.ui.match

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.franciscojavier.escorer.DateConverter
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.ViewMatchBinding
import com.franciscojavier.escorer.dto.match.GameMatchResult
import com.franciscojavier.escorer.inflate
import com.franciscojavier.escorer.loadUrl

class MatchAdapter (
    var matchList : List<GameMatchResult>,
    val listener: (GameMatchResult) -> Unit
    ): RecyclerView.Adapter<MatchAdapter.ViewHolder>(){

        class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            val binding = ViewMatchBinding.bind(view)
            fun bind(match: GameMatchResult){
                if(match.status=="canceled"){
                    binding.matchDate.text = match.status
                    binding.matchDate.setTextColor(Color.RED)
                    binding.matchStatus.visibility = View.GONE
                }else{
                    binding.matchDate.text = match.beginAt?.let { DateConverter(it) }
                    binding.matchStatus.text = match.status
                }


                if(match.opponents.isNotEmpty()) {
                    if (match.opponents[0].opponent.name != "") {
                        binding.opponent1Name.text = match.opponents[0].opponent.name
                    } else {
                        binding.opponent1Name.text = "no_name"
                    }
                    if (match.opponents[1].opponent.name != "") {
                        binding.opponent2Name.text = match.opponents[1].opponent.name
                    } else {
                        binding.opponent2Name.text = "no_name"
                    }

                    if (match.opponents[0].opponent.imageUrl != "") {
                        binding.opponent1Image.loadUrl(match.opponents[0].opponent.imageUrl)
                    } else {
                        binding.opponent1Image.setImageResource(R.drawable.no_image)
                    }
                    if (match.opponents[1].opponent.imageUrl != "") {
                        binding.opponent2Image.loadUrl(match.opponents[1].opponent.imageUrl)
                    } else {
                        binding.opponent2Image.setImageResource(R.drawable.no_image)
                    }
                }else{
                    binding.opponent1Name.text = "no_name"
                    binding.opponent2Name.text = "no_name"
                    binding.opponent1Image.setImageResource(R.drawable.no_image)
                    binding.opponent2Image.setImageResource(R.drawable.no_image)
                }

              if(match.status==("finished") && match.winnerId == match.opponents[0].opponent.id){
                    binding.opponent1Name.setTextColor(Color.GREEN)
                    binding.opponent2Name.setTextColor(Color.RED)
                }else if (match.status==("finished") && match.winnerId == match.opponents[1].opponent.id){
                    binding.opponent2Name.setTextColor(Color.GREEN)
                    binding.opponent1Name.setTextColor(Color.RED)
                }

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = parent.inflate(R.layout.view_match, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(matchList[position])
            holder.itemView.setOnClickListener{
                listener(matchList[position])
            }
        }

        override fun getItemCount(): Int = matchList.size
}