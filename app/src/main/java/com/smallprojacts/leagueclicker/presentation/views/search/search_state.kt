package com.smallprojacts.leagueclicker.presentation.views.search

import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.domain.models.Filters

data class SearchState(
    var isFilterEnabled: Boolean = false,
    var filters: Filters? = null,
    var regionUid: String? = null,
    var legacyUid: String? = null,
    var positionUid: String? = null,
    var text: String? = null,
    var filteredChampions: List<AllChamp> = emptyList(),
)