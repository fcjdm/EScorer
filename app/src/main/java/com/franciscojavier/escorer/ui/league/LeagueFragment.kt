package com.franciscojavier.escorer.ui.league

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.FragmentLeagueBinding
import com.franciscojavier.escorer.dto.league.LeaguesResult
import com.franciscojavier.escorer.dto.game.GamesResult
import com.franciscojavier.escorer.ui.match.MatchFragment.Companion.EXTRA_LEAGUE
import kotlinx.coroutines.launch

class LeagueFragment : Fragment(R.layout.fragment_league) {
    private val adapter = LeagueAdapter(emptyList()){ league -> navigateTo(league)}

    private val viewModel : LeagueViewModel by viewModels {
        LeagueViewModelFactory(arguments?.getParcelable<GamesResult>(EXTRA_GAME)!!.slug,
        getString(R.string.token))
    }

    companion object{
        const val EXTRA_GAME = "LeagueFragment:Game"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentLeagueBinding.bind(view).apply {
            recyclerLeague.adapter = adapter

            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {

                    viewModel.state.collect { state ->
                        progress.visibility = if (state.loading) View.VISIBLE else View.GONE
                        adapter.leagueList = state.leagues
                        adapter.notifyDataSetChanged()
                    }
                }

            }

        }
    }

    private fun navigateTo(league: LeaguesResult) {
        findNavController().navigate(
            R.id.action_leagueFragment2_to_matchFragment,
            bundleOf(EXTRA_LEAGUE to league)
        )

    }


}