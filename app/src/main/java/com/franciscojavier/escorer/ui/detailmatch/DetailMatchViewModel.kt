package com.franciscojavier.escorer.ui.detailmatch

import androidx.lifecycle.*
import com.franciscojavier.escorer.dto.game.GamesResult
import com.franciscojavier.escorer.dto.league.LeaguesResult
import com.franciscojavier.escorer.dto.match.GameMatchResult
import com.franciscojavier.escorer.ui.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailMatchViewModel(match: GameMatchResult) : ViewModel() {
    private val _state = MutableLiveData(UiState(match))
    val state: LiveData<UiState> get() = _state


    init{
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = _state.value?.copy(match = match)

        }
    }

    data class UiState(
        val match: GameMatchResult
    )
}
@Suppress("UNCHECKED_CAST")
class DetailMatchViewModelFactory(private val match: GameMatchResult): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailMatchViewModel(match) as T
    }

}