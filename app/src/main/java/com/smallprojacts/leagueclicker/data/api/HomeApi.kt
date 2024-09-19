package com.smallprojacts.leagueclicker.data.api

import TokenManager
import android.util.Log
import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.domain.models.MyChamp
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class HomeApi {
    val jsonConfig = Json {
        ignoreUnknownKeys = true // This will ignore any unknown keys in the JSON response
    }
    suspend fun getUserName(): String? {

        val token = TokenManager.getToken()

        if (token.isNullOrEmpty()) {
            Log.e("HomeApi", "Token is null or empty")
            return null
        }
        return try {
            val response = ClientConfig.client.get(RemoteRoutes.WHO_AM_I) {
                headers {
                    bearerAuth(token)
                }
                contentType(ContentType.Application.Json)
            }
            when (response.status) {
                HttpStatusCode.OK -> {
                    val jsonResponse = Json.parseToJsonElement(response.body()).jsonObject
                    val userName = jsonResponse["name"]?.jsonPrimitive?.content
                    if (userName != null) {
                        Log.d("HomeApi", "User name fetched successfully: $userName")
                        return userName
                    } else {
                        Log.e("HomeApi", "User name not found in the response: ${response.bodyAsText()}")
                        return null
                    }
                }
                else -> {
                    Log.e("HomeApi", "Failed to fetch user name: ${response.status} - ${response.bodyAsText()}")
                    null
                }
            }
        } catch (e: Exception) {
            Log.e("HomeApi", "Error fetching user name: ${e.message}", e)
            null
        }

    }
    suspend fun getChamps(): List<AllChamp> {
        return try {
            Log.d("HomeApi", "Fetching champions from API...")

            val response = ClientConfig.client.get(RemoteRoutes.ALL_CHAMP) {
                contentType(ContentType.Application.Json)
            }

            Log.d("HomeApi", "Response status: ${response.status.value}")

            if (response.status.value == 200) {
                val jsonResponse = response.bodyAsText() // Get the response body as a string
                Log.d("HomeApi", "Success: Response body -> $jsonResponse")

                // Deserialize the JSON response into a list of AllChamp objects
                jsonConfig.decodeFromString<List<AllChamp>>(jsonResponse)
            } else {
                Log.e("HomeApi", "Error: Status Code -> ${response.status.value}")
                emptyList() // Return an empty list if the response is not successful
            }

        } catch (e: Exception) {
            Log.e("HomeApi", "Exception caught: ${e.message}")
            e.printStackTrace()
            emptyList() // Return an empty list if there's an exception
        }
    }
    suspend fun getMyChamps(): List<MyChamp> {
        return try {

            ClientConfig.client.get(RemoteRoutes.GETCHAMP) {
                headers {
                    append(
                        "Authorization",
                        "Bearer 1|NmY8owx1nVjRnQV4y71lv0eCUk0sh8HUPfJ3g2pX48b49411"
                    )
                }
            }.body<List<MyChamp>>()
        } catch (e: Exception) {
            Log.e("Abubaker", "Exception caught: ${e.message}")
            e.printStackTrace()
            emptyList() // Return an empty list if there's an exception
        }
    }
}
