package com.example.smartlab.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlab.api.Repository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/** ViewModel - хранит данные, связанные с пользовательским интерфейсом, и управляет ими.*/
class ViewModelMain(private val repository: Repository) : ViewModel() {
    /** Каналы (Channel) позволяют передавать потоки данных*/
    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()
    fun sendCodeToEmail(email: String) {
        viewModelScope.launch {
            repository.sendCodeEmail(email).collect {
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
}