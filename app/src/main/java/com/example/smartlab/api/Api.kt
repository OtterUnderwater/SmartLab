package com.example.smartlab.api

import com.example.smartlab.models.Catalog
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

//Интерфейс запроса к апи, конец url используется в Bulder() см. RetrofitInstance
interface Api {
    /** suspend - позволяет выполнять асинхронное программирование и упрощает работу с сопрограммами.
     * Данную функцию можно приостановить и возобновить позже, не блокируя поток выполнения.*/
    @POST("api/SendCode")
    suspend fun sendCodeEmail(@Header("User-email") email: String):String

    @POST("api/SignIn")
    suspend fun signIn(@Header("User-email") email: String, @Header("User-code") code: String):String

    @GET("api/Catalog")
    suspend fun getCatalog(): List<Catalog>
}