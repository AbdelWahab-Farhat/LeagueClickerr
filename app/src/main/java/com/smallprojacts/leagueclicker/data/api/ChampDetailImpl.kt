package com.smallprojacts.leagueclicker.data.api

import android.util.Log
import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.domain.models.MyChamp
import com.smallprojacts.leagueclicker.domain.models.repositories.ChampDetailsRepository
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.utils.EmptyContent.headers
class ChampDetailImpl : ChampDetailsRepository {
    override val client = ClientConfig.client
    override suspend fun getChampDetails(champId: Int): AllChamp {
        return try {
            val test = client.get("${RemoteRoutes.GETDETAILCHAMP}$champId");
            Log.d("tester", "${test.body<AllChamp>()}")
            test.body<AllChamp>()
        } catch (e: Exception) {
            e.printStackTrace()
            AllChamp()
        }
    }

    override suspend fun getMyChampDetails(): List<MyChamp> {
        return try {
            client.get("${RemoteRoutes.GETMYDETAILCHAMP}") {
                headers {
                    //  append("Authorization", "Bearer ${TokenManager.getToken()}")
                    append(
                        "Authorization",
                        "Bearer 2|VYlyjcS0wiuqT9bSLnM2KUUVOXabjl5M9glFwIQV2f59352e"
                    )
                }
            }.body<List<MyChamp>>()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

}

