package com.smallprojacts.leagueclicker.presentation.views.search

import com.smallprojacts.leagueclicker.domain.models.Filters

sealed class SearchEvent {
    data object FilterToggle : SearchEvent()
    data class OnChampionSearch(
        var regionUid: String? = null,
        var legacyUid: String? = null,
        var positionUid: String? = null,
        var text: String? = null,
    ) : SearchEvent()

    data object OnChampionClick : SearchEvent()

    data class OnSearchChange(
        val text: String?
    ) : SearchEvent()
}