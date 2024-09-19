package com.smallprojacts.leagueclicker.presentation.views.search

import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smallprojacts.leagueclicker.domain.models.repositories.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel() {
    var state by mutableStateOf(SearchState())
        private set

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.FilterToggle -> filterToggle()
            is SearchEvent.OnChampionSearch -> onChampionSearch(
                regionUid = event.regionUid,
                legacyUid = event.legacyUid,
                positionUid = event.positionUid,
                text = event.text
            )

            is SearchEvent.OnChampionClick -> {}
            is SearchEvent.OnSearchChange -> onSearchChanged(event.text)
        }
    }

    private fun filterToggle() {
        viewModelScope.launch {

            if (state.filters == null)
                state = state.copy(
                    isFilterEnabled = !state.isFilterEnabled,
                    filters = searchRepository.getFilters()
                )
            else
                state = state.copy(
                    isFilterEnabled = !state.isFilterEnabled,
                )
        }
    }
    private fun onChampionSearch(
        regionUid: String?,
        legacyUid: String?,
        positionUid: String?,
        text: String?
    ) {
        viewModelScope.launch {
            state = state.copy(
                regionUid = regionUid,
                legacyUid = legacyUid,
                positionUid = positionUid,
                text = text,
                filteredChampions =
                searchRepository.search(regionUid, legacyUid, positionUid, text)
            )
        }
    }
    private fun onSearchChanged(text: String?) {
        viewModelScope.launch {
            state = state.copy(
                text = text
            )
        }
    }
}