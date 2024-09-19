package com.smallprojacts.leagueclicker.domain.models.repositories

import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.domain.models.MyChamp
import io.ktor.client.HttpClient

interface ChampDetailsRepository {
    val client: HttpClient


    suspend fun getChampDetails(champId: Int): AllChamp

    suspend fun getMyChampDetails(): List<MyChamp>
}
