package com.example.smartlab.api

import com.example.smartlab.objects.UrlData
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // Создаем перехватчик HttpLoggingInterceptor (как сетевой LogCat)
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        // Существует несколько уровней перехвата данных: NONE, BASIC, HEADERS, BODY.
        // Последний вариант самый информативный, но при больших потоках данных информация забьёт весь экран.
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Создаем конвертер для GsonConverterFactory
    private val gson = GsonBuilder().setLenient().create()

    // Создаем клиента и подключаем перехватчик к веб-клиенту
    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    // Создаем объект для запроса к серверу
    val api: Api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(UrlData.BASE_URL)
        .client(client)
        .build()
        .create(Api::class.java)
    // Получаем объект Retrofit
    // В методе create() указываем наш класс интерфейса с запросами к сайту
}