package com.example.smartlab.objects

import android.content.Context
import android.content.SharedPreferences

/** Сохраняем данные в постоянную память устройства (а вообще в кэш)
 * Не слишком важные данные!:
 * Статус пользователя
 * (0 - открытие приложение,
 * 1 - пролистывание OnBoard,
 * 2 - зарегестрированный пользователь)
 * Тема выбранная пользователем*/
/* Подробнее: https://developer.alexanderklimov.ru/android/theory/sharedpreferences.php */
object CachePreferences {
    private lateinit var statusSystem: SharedPreferences

    // Чтобы создать или изменить общие настройки, необходимо вызвать getSharedPreferences
    //по умолчанию MODE_PRIVATE - только приложение имеет доступ к настройкам.
    fun init(context: Context){
        statusSystem = context.getSharedPreferences("statusSystem", Context.MODE_PRIVATE)
    }

    //Переменная статуса пользователя
    var status: Int
        get() = statusSystem.getInt("status", 0)
        set(value) = statusSystem.edit().putInt("status", value).apply()
}