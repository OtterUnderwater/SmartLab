package com.example.smartlab.viewModel

import com.example.smartlab.api.Result
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.smartlab.api.Repository
import com.example.smartlab.models.Catalog
import com.example.smartlab.objects.RoutesScreens
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/** ViewModel - хранит данные, связанные с пользовательским интерфейсом, и управляет ими.*/
class ViewModelMain(private val repository: Repository) : ViewModel() {
    private var emailStr = ""
    private var codeStr = ""
    var codeInCorrection = mutableStateOf(false)
    /** Переменная для каталога*/
    private val _catalog = MutableStateFlow<List<Catalog>>(emptyList())
    val catalog = _catalog.asStateFlow()
    /** Каналы (Channel) позволяют передавать потоки данных*/
    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    //Функция для отправки кода на email
    fun sendCodeToEmail(email: String) {
        emailStr = email
        viewModelScope.launch {
            repository.sendCodeEmail(emailStr).collect {
                when (it) {
                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is Result.Success -> {
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
                    is Result.Error -> {
                        codeInCorrection.value = false
                    }
                    is Result.Success -> {
                        // Переход на следующий экран после успешного ответа от API
                        navHostController.navigate(RoutesScreens.CREATE_PASSWORD)
                        codeInCorrection.value = true //Если ответ удачный
                    }
                }
            }
        }
    }

    //Функция для получения каталога из Апи
    fun getListCatalog() {
        viewModelScope.launch {
            //Получаем данные и обробатываем их
            repository.getCatalog().collect { result ->
                when(result) {
                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is Result.Success -> {
                        result.data?.let {
                            item -> _catalog.update { item }
                        }
                        }
                    }
                }
            }
        }
    }
