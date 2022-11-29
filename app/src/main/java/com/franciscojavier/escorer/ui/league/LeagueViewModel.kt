package com.franciscojavier.escorer.ui.league

import androidx.lifecycle.*
import com.franciscojavier.escorer.dto.game.GamesResult
import com.franciscojavier.escorer.dto.league.LeaguesResult
import com.franciscojavier.escorer.model.server.PandaScoreClient
import com.franciscojavier.escorer.ui.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LeagueViewModel(slug: String, token: String) : ViewModel() {
    private val _state = MutableLiveData(UiState())
    val state: LiveData<UiState> get() = _state


    init{
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = _state.value?.copy(loading = true)
            val getAllLeagues = PandaScoreClient.service.getLeagues(slug ,token)
            val leaguesWithMatches : MutableList<LeaguesResult> = mutableListOf()

            getAllLeagues?.forEach {
                val matches = PandaScoreClient.service.getMatches(it.slug, token)
                if(matches.isNotEmpty()){
                    leaguesWithMatches.add(it)
                }
            }

            _state.value = _state.value?.copy(leagues = leaguesWithMatches)
            _state.value = _state.value?.copy(loading = false)

        }
    }

    fun navigateTo(league: LeaguesResult) {
        _state.value = _state.value?.copy(navigateTo = league)
    }

    fun onNavigateDone(){
        _state.value = _state.value?.copy(navigateTo = null)
    }

    data class UiState(
        val loading: Boolean = false,
        val leagues: List<LeaguesResult> = emptyList(),
        val navigateTo: LeaguesResult? = null
    )
}
@Suppress("UNCHECKED_CAST")
class LeagueViewModelFactory(private val slug: String, private val token: String): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LeagueViewModel(slug, token) as T
    }

}