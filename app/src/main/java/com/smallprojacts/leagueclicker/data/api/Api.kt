package com.smallprojacts.leagueclicker.data.api

import android.util.Log
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import kotlinx.serialization.Serializable


class NetworkService  {


    suspend fun registerUser(username: String, email: String, password: String):Int {
        val response = ClientConfig.client.post(RemoteRoutes.REGISTER) {
            contentType(ContentType.Application.Json)
            setBody(RegisterRequest(username, email, password,password))
        }
        return when (response.status.value) {
            201 , 200 -> {
                1;
            }

            else -> {
                Log.d("NetworkService", "Register success: ${response.bodyAsText()}")
                0;
            }
        }
    }
    suspend fun loginUser(email: String, password: String): Int {
        return try {
            val response = ClientConfig.client.post(RemoteRoutes.LOGIN) {
                contentType(ContentType.Application.Json)
                setBody(LoginRequest(email, password))
            }

            Log.d("NetworkService", "Login response: ${response.status.value}")

            when (response.status) {
                HttpStatusCode.OK, HttpStatusCode.Created -> {
                    Log.d("NetworkService", "Login failed: ${response.bodyAsText()}")
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
    data class RegisterRequest(val name: String,
                               val email: String,
                               val password: String,
                               val password_confirmation: String)

    @Serializable
    data class LoginRequest(val email: String, val password: String)

}