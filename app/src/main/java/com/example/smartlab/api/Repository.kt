package com.example.smartlab.api

import com.example.smartlab.models.Catalog
import kotlinx.coroutines.flow.Flow

interface Repository {
    /*    Для создания асинхронного потока данных применяется интерфейс Flow.
    То есть по сути асинхронный поток - это объект Flow.
    Он типизируется типом тех данных, которые должны передаваться в потоке.*/
    //Метод для получения данных из API. Завернутых в пользовательский класс обработки данных
    suspend fun sendCodeEmail(email:String): Flow<Result<String>>
    suspend fun signIn(email:String, code:String): Flow<Result<String>>
    suspend fun getCatalog():Flow<Result<List<Catalog>>>
}