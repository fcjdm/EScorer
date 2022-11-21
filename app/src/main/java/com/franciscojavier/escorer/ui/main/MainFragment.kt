package com.franciscojavier.escorer.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.FragmentMainBinding
import com.franciscojavier.escorer.model.server.PandaScoreClient
import kotlinx.coroutines.launch


class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController: NavController = Navigation.findNavController(view)
        val gamesAdapter = GameAdapter(emptyList()) {
            findNavController().navigate(R.id.action_mainFragment_to_leagueFragment2)
        }

        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = gamesAdapter

            lifecycleScope.launch {
                val token = getString(R.string.token)
                val getAllGames = PandaScoreClient.service.getGames(token)
                gamesAdapter.gameList = getAllGames
                gamesAdapter.notifyDataSetChanged()

            }

        }
    }

}

