package com.franciscojavier.escorer.ui.main

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
import com.franciscojavier.escorer.databinding.FragmentMainBinding
import com.franciscojavier.escorer.dto.game.GamesResult
import com.franciscojavier.escorer.ui.league.LeagueFragment
import kotlinx.coroutines.launch


class MainFragment : Fragment(R.layout.fragment_main) {
    private val adapter = GameAdapter(emptyList()){ game -> navigateTo(game)}

    private val viewModel : MainViewModel by viewModels{MainViewModelFactory(getString(R.string.token))}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view).apply {
            recyclerGame.adapter = adapter

            viewLifecycleOwner.lifecycleScope.launch{
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){

                    viewModel.state.collect{ state ->
                        progress.visibility = if(state.loading) View.VISIBLE else View.GONE
                        adapter.gameList = state.games
                        adapter.notifyDataSetChanged()
                    }
                }

            }


        }


    }

    private fun navigateTo(game: GamesResult) {
        findNavController().navigate(
            R.id.action_mainFragment_to_leagueFragment2,
            bundleOf(LeagueFragment.EXTRA_GAME to game)
        )

    }

}

