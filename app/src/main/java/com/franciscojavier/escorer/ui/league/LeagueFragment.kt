package com.franciscojavier.escorer.ui.league

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.FragmentLeagueBinding
import com.franciscojavier.escorer.dto.game.GamesResultItem

class LeagueFragment : Fragment(R.layout.fragment_main) {

    companion object{
        const val EXTRA_GAME = "LeagueFragment:Game"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentLeagueBinding.bind(view)

        val game = arguments?.getParcelable<GamesResultItem>(EXTRA_GAME)

        if (game != null) {
            Toast.makeText(activity, game.name, Toast.LENGTH_SHORT)
        }


    }


}