package com.example.smartlab.api

import kotlinx.coroutines.flow.Flow

interface Repository {

    //Метод для получения данных из API. "Завернутых" в пользоватлеьский класс обработки данных
    suspend fun sendCodeEmail(email:String): Flow<Result<String>>
/*    Для создания асинхронного потока данных применяется интерфейс Flow.
То есть по сути асинхронный поток - это объект Flow.
Он типизируется типом тех данных, которые должны передаваться в потоке.*/
}