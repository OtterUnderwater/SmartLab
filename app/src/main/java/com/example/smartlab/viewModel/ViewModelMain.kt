package com.example.smartlab.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.smartlab.api.Repository
import com.example.smartlab.objects.RoutesScreens
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

/** ViewModel - хранит данные, связанные с пользовательским интерфейсом, и управляет ими.*/
class ViewModelMain(private val repository: Repository) : ViewModel() {
    /** Каналы (Channel) позволяют передавать потоки данных*/
    private val _showErrorToastChannel = Channel<Boolean>()
    private var emailStr = ""
    private var codeStr = ""

    //Функция для отправки кода на email
    fun sendCodeToEmail(email: String) {
        emailStr = email
        viewModelScope.launch {
            repository.sendCodeEmail(emailStr).collect {
                when (it) {
                    is com.example.smartlab.api.Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is com.example.smartlab.api.Result.Success -> {
                        _showErrorToastChannel.send(false)
                    }
                }
            }
        }
    }

    //Функция для проверки кода
    fun checkCodeAndEmail(code: MutableList<String>, navHostController: NavHostController) {
        //парсим код в строку
        codeStr = code.joinToString("")
        viewModelScope.launch {
            //Лог для проверки
            Log.d("Email и код:", emailStr + " " + codeStr)
            repository.signIn(emailStr, codeStr).collect {
                when (it) {
                    is com.example.smartlab.api.Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is com.example.smartlab.api.Result.Success -> {
                        // Переход на следующий экран после успешного ответа от API
                        navHostController.navigate(RoutesScreens.CREATEPASSWORD)
                        _showErrorToastChannel.send(false)
                    }
                }
            }
        }
    }
}