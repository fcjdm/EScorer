package com.franciscojavier.escorer.ui.match

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.ViewMatchBinding
import com.franciscojavier.escorer.dto.match.MatchResultItem
import com.franciscojavier.escorer.inflate
import com.franciscojavier.escorer.loadUrl

class MatchAdapter (
    var matchList : List<MatchResultItem>,
    val listener: (MatchResultItem) -> Unit
    ): RecyclerView.Adapter<MatchAdapter.ViewHolder>(){

        class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            val binding = ViewMatchBinding.bind(view)
            fun bind(match: MatchResultItem){
                binding.matchDate.text = match.beginAt
                binding.opponent1Name.text = match.opponents[0].opponent.name
                if(match.opponents[0].opponent.imageUrl != null){
                    binding.opponent1Image.loadUrl(match.opponents[0].opponent.imageUrl)
                }else{
                    binding.opponent1Image.setImageResource(R.drawable.no_image)
                }

                binding.opponent2Name.text = match.opponents[1].opponent.name
                if(match.opponents[1].opponent.imageUrl != null){
                    binding.opponent2Image.loadUrl(match.opponents[1].opponent.imageUrl)
                }else{
                    binding.opponent2Image.setImageResource(R.drawable.no_image)
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