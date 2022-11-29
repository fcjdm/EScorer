package com.franciscojavier.escorer.ui.detailmatch

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.franciscojavier.escorer.DateConverter
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.FragmentDetailMatchBinding
import com.franciscojavier.escorer.dto.match.GameMatchResult
import com.franciscojavier.escorer.loadUrl
import kotlinx.coroutines.launch

class DetailMatchFragment : Fragment(R.layout.fragment_detail_match) {
    private val viewModel : DetailMatchViewModel by viewModels {
        DetailMatchViewModelFactory(arguments?.getParcelable(EXTRA_MATCH)!!)
    }

    companion object{
        const val EXTRA_MATCH = "MatchFragment:Match"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailMatchBinding.bind(view).apply {

            viewModel.state.observe(viewLifecycleOwner) { state ->
                if (state.match.status == "canceled") {
                    detailMatchDate.text = state.match.status
                    detailMatchDate.setTextColor(Color.RED)
                    detailStatus.visibility = View.GONE
                } else {
                    detailMatchDate.text = state.match.beginAt?.let { DateConverter(it) }
                    detailStatus.text = state.match.status
                }


                if (state.match.opponents.isNotEmpty()) {
                    if (state.match.opponents[0].opponent.name != "") {
                        detailOpponentName1.text = state.match.opponents[0].opponent.name
                    } else {
                        detailOpponentName1.text = "no_name"
                    }
                    if (state.match.opponents[1].opponent.name != "") {
                        detailOpponentName2.text = state.match.opponents[1].opponent.name
                    } else {
                        detailOpponentName2.text = "no_name"
                    }

                    if (state.match.opponents[0].opponent.imageUrl != "") {
                        detailOpponentImage1.loadUrl(state.match.opponents[0].opponent.imageUrl)
                    } else {
                        detailOpponentImage1.setImageResource(R.drawable.no_image)
                    }
                    if (state.match.opponents[1].opponent.imageUrl != "") {
                        detailOpponentImage2.loadUrl(state.match.opponents[1].opponent.imageUrl)
                    } else {
                        detailOpponentImage2.setImageResource(R.drawable.no_image)
                    }
                } else {
                    detailOpponentName1.text = "no_name"
                    detailOpponentName2.text = "no_name"
                    detailOpponentImage1.setImageResource(R.drawable.no_image)
                    detailOpponentImage2.setImageResource(R.drawable.no_image)
                }

                if (state.match.status == ("finished") && state.match.winnerId == state.match.opponents[0].opponent.id) {
                    detailOpponentName1.setTextColor(Color.GREEN)
                    detailOpponentName1.text = detailOpponentName1.text as String + " (ganador)"
                    detailOpponentName2.setTextColor(Color.RED)
                } else if (state.match.status == ("finished") && state.match.winnerId == state.match.opponents[1].opponent.id) {
                    detailOpponentName2.setTextColor(Color.GREEN)
                    detailOpponentName2.text = detailOpponentName2.text as String + " (ganador)"
                    detailOpponentName1.setTextColor(Color.RED)
                }

                detailLeagueName.text = state.match.league.name
                detailGameName.text = state.match.videogame.name
            }
        }


    }

}