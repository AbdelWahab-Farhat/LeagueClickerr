package com.smallprojacts.leagueclicker.data.api

import TokenManager
import android.util.Log
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive


class NetworkService  {

     fun logout(): Boolean {
        return try {
            TokenManager.clearToken()
            true
        } catch (e: Exception) {
            false
        }
    }
    suspend fun registerUser(username: String, email: String, password: String):Int {

        val response = ClientConfig.client.post(RemoteRoutes.REGISTER) {
            contentType(ContentType.Application.Json)
            setBody(RegisterRequest(username, email, password,password))
        }
        return when (response.status.value) {
            201 , 200 -> {
                1
            }

            else -> {
                Log.d("NetworkService", "Register success: ${response.bodyAsText()}")
                0
            }
        }

    }
    suspend fun loginUser(email: String, password: String) {
         try {
            val response = ClientConfig.client.post(RemoteRoutes.LOGIN) {
                contentType(ContentType.Application.Json)
                setBody(LoginRequest(email, password))
            }

            Log.d("NetworkService", "Login response: ${response.status.value}")

            when (response.status) {
                HttpStatusCode.OK, HttpStatusCode.Created -> {
                    val jsonResponse = Json.parseToJsonElement(response.body()).jsonObject
                    val token = jsonResponse["token"]?.jsonPrimitive?.content
                    if (token != null) {
                        TokenManager.saveToken(token)
                    }
                    Log.d("NetworkService", "Login failed: ${response.bodyAsText()}")

                }
                else -> {
                    Log.d("NetworkService", "Login failed: ${response.bodyAsText()}")

                }
            }
        } catch (e: Exception) {
            Log.e("NetworkService", "Error logging in: ${e.message}")

        }
    }

    @Serializable
    data class RegisterRequest(val name: String,
                               val email: String,
                               val password: String,
                               val password_confirmation: String)

    @Serializable
    data class LoginRequest(val email: String, val password: String)

}