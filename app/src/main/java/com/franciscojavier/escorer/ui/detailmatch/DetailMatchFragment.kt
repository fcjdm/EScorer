package com.franciscojavier.escorer.ui.detailmatch

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.FragmentDetailMatchBinding
import com.franciscojavier.escorer.databinding.FragmentLeagueBinding
import com.franciscojavier.escorer.dto.game.GamesResultItem
import com.franciscojavier.escorer.dto.league.LeaguesResultItem
import com.franciscojavier.escorer.dto.match.MatchResultItem
import com.franciscojavier.escorer.loadUrl
import com.franciscojavier.escorer.model.server.PandaScoreClient
import com.franciscojavier.escorer.ui.league.LeagueAdapter
import com.franciscojavier.escorer.ui.league.LeagueFragment
import com.franciscojavier.escorer.ui.league.LeagueViewModel
import com.franciscojavier.escorer.ui.league.LeagueViewModelFactory
import com.franciscojavier.escorer.ui.match.MatchViewModel
import com.franciscojavier.escorer.ui.match.MatchViewModelFactory
import kotlinx.coroutines.launch

class DetailMatchFragment : Fragment(R.layout.fragment_detail_match) {
    private val viewModel : DetailMatchViewModel by viewModels {
        DetailMatchViewModelFactory(arguments?.getParcelable<MatchResultItem>(EXTRA_MATCH)!!)
    }

    companion object{
        const val EXTRA_MATCH = "MatchFragment:Match"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailMatchBinding.bind(view).apply {

            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.state.collect{ state ->
                        if( state.match != null){
                        detailOpponentName1.text = state.match.opponents[0].opponent.name
                        if(state.match.opponents[0].opponent.imageUrl != null){
                            detailOpponentImage1.loadUrl(state.match.opponents[0].opponent.imageUrl)
                        }else{
                            detailOpponentImage1.setImageResource(R.drawable.no_image)
                        }
                        detailOpponentName2.text = state.match.opponents[0].opponent.name
                        if(state.match.opponents[1].opponent.imageUrl != null){
                            detailOpponentImage2.loadUrl(state.match.opponents[0].opponent.imageUrl)
                        }else{
                            detailOpponentImage2.setImageResource(R.drawable.no_image)
                        }

                        detailMatchDate.text = state.match.beginAt
                        detailStatus.text = state.match.status
                        detailLeagueName.text = state.match.league.name
                        detailGameName.text = state.match.videogame.name
                    }
                    }


                }

            }




        }

    }



}