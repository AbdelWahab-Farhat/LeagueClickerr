package com.smallprojacts.leagueclicker.data.api

import android.util.Log
import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.domain.models.MyChamp
import com.smallprojacts.leagueclicker.domain.models.repositories.ChampDetailsRepository
import io.ktor.client.call.body
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.utils.EmptyContent.headers
import io.ktor.http.ContentType
import io.ktor.http.Parameters
import io.ktor.http.contentType
import kotlinx.serialization.json.JsonObject

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
                      append("Authorization", "Bearer ${TokenManager.getToken()}")
//                    append(
//                        "Authorization",
//                        "Bearer 1|NmY8owx1nVjRnQV4y71lv0eCUk0sh8HUPfJ3g2pX48b49411"
//                    )
                }
            }.body<List<MyChamp>>()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun addchamp(champId: Int): Boolean {
        return try {

            Log.d("abuab", "addchamp: $champId")

            val res = client.post("${RemoteRoutes.ADDCHAMP}") {
                headers {
                    append("Authorization", "Bearer ${TokenManager.getToken()}")

//                    append(
//                        "Authorization",
//                        "Bearer 1|NmY8owx1nVjRnQV4y71lv0eCUk0sh8HUPfJ3g2pX48b49411"
//                    )
                }
                contentType(ContentType.Application.FormUrlEncoded)
                setBody(FormDataContent(Parameters.build {
                    append("champion_id", champId.toString())
                }))
            }
            Log.d("abuab", "addchamp: $res")

            true
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("abuab", "addchamp: sajnkjkndasjnkfkjdns")

            false
        }
    }

}

data class ChampionRequest(val champion_id: String)


