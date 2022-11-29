package com.franciscojavier.escorer.ui.main

import androidx.lifecycle.*
import com.franciscojavier.escorer.dto.game.GamesResult
import com.franciscojavier.escorer.model.server.PandaScoreClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(token: String) : ViewModel() {
    private val _state = MutableLiveData(UiState())
    val state: LiveData<UiState> get() = _state


    init {
        viewModelScope.launch(Dispatchers.Main){
            _state.value = _state.value?.copy(loading = true)
            val getAllGames = PandaScoreClient.service.getGames(token)
            _state.value = _state.value?.copy(games = getAllGames)
            _state.value = _state.value?.copy(loading = false)

        }
    }

    fun navigateTo(game: GamesResult) {
        _state.value = _state.value?.copy(navigateTo = game)
    }

    fun onNavigateDone(){
        _state.value = _state.value?.copy(navigateTo = null)
    }

    data class UiState(
        val loading: Boolean = false,
        val games: List<GamesResult> = emptyList(),
        val navigateTo: GamesResult? = null
    )
}
@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val token: String): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(token) as T
    }
}