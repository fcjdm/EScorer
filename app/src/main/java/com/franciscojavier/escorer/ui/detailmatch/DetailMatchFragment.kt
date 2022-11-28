package com.franciscojavier.escorer.ui.detailmatch

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
        DetailMatchViewModelFactory(arguments?.getParcelable<GameMatchResult>(EXTRA_MATCH)!!)
    }

    companion object{
        const val EXTRA_MATCH = "MatchFragment:Match"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailMatchBinding.bind(view).apply {

            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.state.collect { state ->


                        if (state.match != null) {
                            detailOpponentName1.text = state.match.opponents[0].opponent.name
                            if (state.match.opponents[0].opponent.imageUrl != "") {
                                detailOpponentImage1.loadUrl(state.match.opponents[0].opponent.imageUrl)
                            } else {
                                detailOpponentImage1.setImageResource(R.drawable.no_image)
                            }
                            detailOpponentName2.text = state.match.opponents[1].opponent.name
                            if (state.match.opponents[1].opponent.imageUrl != "") {
                                detailOpponentImage2.loadUrl(state.match.opponents[1].opponent.imageUrl)
                            } else {
                                detailOpponentImage2.setImageResource(R.drawable.no_image)
                            }

                            detailStatus.text = state.match.status
                            detailLeagueName.text = state.match.league.name
                            detailGameName.text = state.match.videogame.name
                            detailMatchDate.text = state.match.beginAt?.let { DateConverter(it) }

                        }
                    }


                }

            }




        }

    }



}