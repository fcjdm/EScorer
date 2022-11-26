package com.franciscojavier.escorer.ui.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.franciscojavier.escorer.dto.match.MatchResult
import com.franciscojavier.escorer.model.server.PandaScoreClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MatchViewModel(slug: String, token: String) : ViewModel() {
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()


    init{
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            val getAllMatches = PandaScoreClient.service.getUpcomingMatches(slug ,token)

            _state.update { it.copy(matches = getAllMatches) }
            _state.update { it.copy(loading = false) }

        }
    }

    data class UiState(
        val loading: Boolean = false,
        val matches: MatchResult = MatchResult()
    )
}
@Suppress("UNCHECKED_CAST")
class MatchViewModelFactory(private val slug: String, private val token: String): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MatchViewModel(slug, token) as T
    }

}