package com.franciscojavier.escorer.ui.match

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.FragmentMatchBinding
import com.franciscojavier.escorer.dto.league.LeaguesResultItem
import com.franciscojavier.escorer.dto.match.MatchResultItem
import com.franciscojavier.escorer.model.server.PandaScoreClient
import kotlinx.coroutines.launch

class MatchFragment : Fragment(R.layout.fragment_match) {
    private val adapter = MatchAdapter(emptyList()){ match -> navigateTo(match)}

    companion object{
        const val EXTRA_LEAGUE = "LeagueFragment:League"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMatchBinding.bind(view).apply {
            recyclerMatch.adapter = adapter

            val league = arguments?.getParcelable<LeaguesResultItem>(EXTRA_LEAGUE)

            lifecycleScope.launch {
                val token = getString(R.string.token)
                val getUpcomingMatches = league?.let { PandaScoreClient.service.getUpcomingMatches(it.slug ,token) }
                if (getUpcomingMatches != null) {
                    adapter.matchList = getUpcomingMatches
                }
                adapter.notifyDataSetChanged()

            }
        }


    }

    private fun navigateTo(match: MatchResultItem) {
        findNavController().navigate(
            R.id.action_mainFragment_to_leagueFragment2,
            bundleOf(EXTRA_LEAGUE to match)
        )

    }


}