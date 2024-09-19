package com.smallprojacts.leagueclicker.data.api

import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.domain.models.Filters
import com.smallprojacts.leagueclicker.domain.models.repositories.SearchRepository
import io.ktor.client.call.body
import io.ktor.client.request.get

class SearchImpl : SearchRepository {
    val client = ClientConfig.client
    override suspend fun getFilters(): Filters {
        return try {
            client.get(RemoteRoutes.FILTERS).body<Filters>()
        } catch (e: Exception) {
            Filters()
        }
    }

    override suspend fun search(
    regionUid: String?,
    positionUid: String?,
    legacyUid: String?,
    text: String?
    ): List<AllChamp>
    {
        return try {
            client.get("${RemoteRoutes.SEARCH}search=${text ?: ""}&position_id=${positionUid ?: ""}&region_id=${regionUid ?: ""}&legacy_id=${legacyUid ?: ""}")
                .body<List<AllChamp>>()
        } catch (e: Exception) {
            emptyList()
        }
    }
}