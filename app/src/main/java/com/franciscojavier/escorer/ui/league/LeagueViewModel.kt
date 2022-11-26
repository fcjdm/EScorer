package com.franciscojavier.escorer.ui.league

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.franciscojavier.escorer.dto.game.GamesResult
import com.franciscojavier.escorer.dto.league.LeaguesResult
import com.franciscojavier.escorer.dto.league.LeaguesResultItem
import com.franciscojavier.escorer.model.server.PandaScoreClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LeagueViewModel(slug: String, token: String) : ViewModel() {
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()


    init{
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            val getAllLeagues = PandaScoreClient.service.getLeagues(slug ,token)

            val leaguesWithMatches = LeaguesResult()
            getAllLeagues?.forEach {
                val matches = PandaScoreClient.service.getUpcomingMatches(it.slug, token)
                if(matches.size >= 1){
                    leaguesWithMatches.add(it)
                }
            }

            _state.update { it.copy(leagues = leaguesWithMatches) }
            _state.update { it.copy(loading = false) }

        }
    }

    data class UiState(
        val loading: Boolean = false,
        val leagues: LeaguesResult = LeaguesResult()
    )
}
@Suppress("UNCHECKED_CAST")
class LeagueViewModelFactory(private val slug: String, private val token: String): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LeagueViewModel(slug, token) as T
    }

}