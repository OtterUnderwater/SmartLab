package com.example.smartlab.api

import kotlinx.coroutines.flow.Flow
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {
    /** suspend - позволяет выполнять асинхронное программирование и упрощает работу с сопрограммами.
     * Данную функцию можно приостановить и возобновить позже, не блокируя поток выполнения.*/
    @POST("api/SendCode")
    suspend fun sendCodeEmail(@Header("User-email") email: String):String
}