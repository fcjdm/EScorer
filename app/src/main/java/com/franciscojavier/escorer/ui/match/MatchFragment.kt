package com.franciscojavier.escorer.ui.match

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
import com.franciscojavier.escorer.databinding.FragmentMatchBinding
import com.franciscojavier.escorer.dto.game.GamesResultItem
import com.franciscojavier.escorer.dto.league.LeaguesResultItem
import com.franciscojavier.escorer.dto.match.MatchResultItem
import com.franciscojavier.escorer.model.server.PandaScoreClient
import com.franciscojavier.escorer.ui.detailmatch.DetailMatchFragment.Companion.EXTRA_MATCH
import com.franciscojavier.escorer.ui.league.LeagueFragment
import com.franciscojavier.escorer.ui.league.LeagueViewModel
import com.franciscojavier.escorer.ui.league.LeagueViewModelFactory
import kotlinx.coroutines.launch

class MatchFragment : Fragment(R.layout.fragment_match) {
    private val adapter = MatchAdapter(emptyList()){ match -> navigateTo(match)}

    private val viewModel : MatchViewModel by viewModels {
        MatchViewModelFactory(arguments?.getParcelable<LeaguesResultItem>(EXTRA_LEAGUE)!!.slug,
            getString(R.string.token))
    }

    companion object{
        const val EXTRA_LEAGUE = "LeagueFragment:League"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMatchBinding.bind(view).apply {
            recyclerMatch.adapter = adapter

            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {

                    viewModel.state.collect { state ->
                        progress.visibility = if (state.loading) View.VISIBLE else View.GONE
                        adapter.matchList = state.matches
                        adapter.notifyDataSetChanged()
                    }
                }

            }
        }


    }

    private fun navigateTo(match: MatchResultItem) {
        findNavController().navigate(
            R.id.action_matchFragment_to_detailMatchFragment,
            bundleOf(EXTRA_MATCH to match)
        )

    }


}