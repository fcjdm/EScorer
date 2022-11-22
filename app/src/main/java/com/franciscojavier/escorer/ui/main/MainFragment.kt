package com.franciscojavier.escorer.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.FragmentMainBinding
import com.franciscojavier.escorer.dto.game.GamesResultItem
import com.franciscojavier.escorer.model.server.PandaScoreClient
import com.franciscojavier.escorer.ui.league.LeagueFragment
import kotlinx.coroutines.launch


class MainFragment : Fragment(R.layout.fragment_main) {
    private val adapter = GameAdapter(emptyList()){ game -> navigateTo(game)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view).apply {
            recyclerGame.adapter = adapter

            lifecycleScope.launch {
                val token = getString(R.string.token)
                val getAllGames = PandaScoreClient.service.getGames(token)
                adapter.gameList = getAllGames
                adapter.notifyDataSetChanged()

            }
        }

    }

    private fun navigateTo(game: GamesResultItem) {
        findNavController().navigate(
            R.id.action_mainFragment_to_leagueFragment2,
            bundleOf(LeagueFragment.EXTRA_GAME to game)
        )

    }

}

