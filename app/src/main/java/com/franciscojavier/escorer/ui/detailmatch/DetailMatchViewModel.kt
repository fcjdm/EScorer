package com.franciscojavier.escorer.ui.detailmatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.franciscojavier.escorer.dto.match.MatchResult
import com.franciscojavier.escorer.dto.match.MatchResultItem
import com.franciscojavier.escorer.model.server.PandaScoreClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailMatchViewModel(match: MatchResultItem) : ViewModel() {
    private val _state = MutableStateFlow(UiState(match))
    val state: StateFlow<UiState> = _state.asStateFlow()


    init{
        viewModelScope.launch {
            _state.update { it.copy(match = match) }

        }
    }

    data class UiState(
        val match: MatchResultItem
    )
}
@Suppress("UNCHECKED_CAST")
class DetailMatchViewModelFactory(private val match: MatchResultItem): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailMatchViewModel(match) as T
    }

}