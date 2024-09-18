package com.smallprojacts.leagueclicker.data.api

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.client.utils.EmptyContent.headers
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


class NetworkService  {
    val PORT = 3003;
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true }) // Configure JSON serialization
        }
    }


    suspend fun registerUser(username: String, email: String, password: String):Int {
        val response = client.post("http://192.168.1.98:$PORT/api/register") {
            contentType(ContentType.Application.Json)
            setBody(RegisterRequest(username, email, password,password))
        }
        return when (response.status.value) {
            201 , 200 -> {
                1;
            }

            else -> {
                0;
            }
        }
    }
    suspend fun loginUser(email: String, password: String): Int {
        return try {
            val response = client.post("http://192.168.1.98:$PORT/api/login") {
                contentType(ContentType.Application.Json)
                setBody(LoginRequest(email, password))
            }

            Log.d("NetworkService", "Login response: ${response.status.value}")

            when (response.status) {
                HttpStatusCode.OK, HttpStatusCode.Created -> {
                    1
                }
                else -> {
                    Log.d("NetworkService", "Login failed: ${response.bodyAsText()}")
                    0
                }
            }
        } catch (e: Exception) {
            Log.e("NetworkService", "Error logging in: ${e.message}")
            0
        }
    }

    @Serializable
    data class RegisterRequest(val name: String, val email: String, val password: String, val password_confirmation: String)

    @Serializable
    data class LoginRequest(val email: String, val password: String)

}