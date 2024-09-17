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
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true }) // Configure JSON serialization
        }
    }


    suspend fun registerUser(username: String, email: String, password: String) {
        val response = client.post("http://192.168.1.98:8080/api/register") {

            contentType(ContentType.Application.Json)
            setBody(RegisterRequest(username, email, password,password))
        }
        when (response.status.value) {
            201 , 200 -> {
                // Successfully registered
                Log.d("eee", "Successfully registered user: ${response.status}")
            }
            else -> {
                // Handle error
                Log.d("eee", "error: ${response.bodyAsText()}")
                Log.d("eee", "Failed to register user: ${response.status}")}
        }
    }

    @Serializable
    data class RegisterRequest(val name: String, val email: String, val password: String, val password_confirmation: String)

}