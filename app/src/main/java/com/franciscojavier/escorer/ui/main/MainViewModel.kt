package com.franciscojavier.escorer.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.franciscojavier.escorer.dto.game.GamesResult
import com.franciscojavier.escorer.model.server.PandaScoreClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(token: String) : ViewModel() {
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()


    init{
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            val getAllGames = PandaScoreClient.service.getGames(token)
            _state.update { it.copy(games = getAllGames) }
            _state.update { it.copy(loading = false) }

        }
    }

    data class UiState(
        val loading: Boolean = false,
        val games: GamesResult = GamesResult()
    )
}
@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val token: String): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(token) as T
    }
}