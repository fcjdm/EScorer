package com.franciscojavier.escorer.ui.league

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.franciscojavier.escorer.R
import com.franciscojavier.escorer.databinding.FragmentLeagueBinding
class LeagueFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentLeagueBinding.bind(view).apply {
            Toast.makeText(activity, "text", Toast.LENGTH_SHORT).show()

        }


    }


}