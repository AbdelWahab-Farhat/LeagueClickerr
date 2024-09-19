package com.smallprojacts.leagueclicker.data.api

object RemoteRoutes {
    const val PORT = "3003"
    const val BASE_URL = "http://192.168.1.98:$PORT/api"
    const val REGISTER = "$BASE_URL/register"
    const val LOGIN = "$BASE_URL/login"
}
