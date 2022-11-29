package com.franciscojavier.escorer.ui.match

import androidx.lifecycle.*
import com.franciscojavier.escorer.dto.match.GameMatchResult
import com.franciscojavier.escorer.model.server.PandaScoreClient
import com.franciscojavier.escorer.ui.detailmatch.DetailMatchViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MatchViewModel(slug: String, token: String) : ViewModel() {
    private val _state = MutableLiveData(UiState())
    val state: LiveData<UiState> get() = _state


    init{
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = _state.value?.copy(loading = true)
            val getAllMatches = PandaScoreClient.service.getMatches(slug ,token)

            _state.value = _state.value?.copy(matches = getAllMatches)
            _state.value = _state.value?.copy(loading = false)

        }
    }

    fun navigateTo(match: GameMatchResult) {
        _state.value = _state.value?.copy(navigateTo = match)
    }

    fun onNavigateDone(){
        _state.value = _state.value?.copy(navigateTo = null)
    }


    data class UiState(
        val loading: Boolean = false,
        val matches: List<GameMatchResult> = emptyList(),
        val navigateTo: GameMatchResult? = null
    )
}
@Suppress("UNCHECKED_CAST")
class MatchViewModelFactory(private val slug: String, private val token: String): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MatchViewModel(slug, token) as T
    }

}