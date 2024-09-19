package com.smallprojacts.leagueclicker.domain.models.repositories

import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.domain.models.Filters

interface SearchRepository {

    suspend fun getFilters(): Filters

    suspend fun search(
        regionUid: String?,
        positionUid: String?,
        legacyUid: String?,
        text: String?,
    ) : List<AllChamp>
}