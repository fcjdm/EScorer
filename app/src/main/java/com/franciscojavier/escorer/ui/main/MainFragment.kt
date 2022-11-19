package com.franciscojavier.escorer.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.FragmentMainBinding
import com.franciscojavier.escorer.model.server.PandaScoreClient
import kotlinx.coroutines.launch

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)



        val gamesAdapter = GameAdapter(emptyList()){

        }

        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = gamesAdapter
        }

        lifecycleScope.launch{
            val token = getString(R.string.token)
            val getAllGames = PandaScoreClient.service.getGames(token)
            gamesAdapter.gameList = getAllGames
            gamesAdapter.notifyDataSetChanged()

        }

    }


    }