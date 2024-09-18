package com.smallprojacts.leagueclicker.data.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object RemoteRoutes {
    const val PORT = "3003";
    const val BASE_URL = "http://192.168.1.98:$PORT/api";
    const val REGISTER = "$BASE_URL/register"
    const val LOGIN = "$BASE_URL/login"
}

