package com.example.smartlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.smartlab.api.RepositoryImpl
import com.example.smartlab.api.RetrofitInstance
import com.example.smartlab.navigation.Navigation
import com.example.smartlab.objects.CachePreferences
import com.example.smartlab.ui.theme.SmartLabTheme
import com.example.smartlab.viewModel.ViewModelMain

/** Из главной активности просто вызываем
 * Navigation() для переключения между страницами*/
class MainActivity : ComponentActivity() {
    //Создание провайдера ViewModel
    private val viewModelSmartLab by viewModels<ViewModelMain>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ViewModelMain(RepositoryImpl(RetrofitInstance.api))
                        as T
            }
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartLabTheme {
                //Передает контекст в CachePreferences!!
                CachePreferences.init(LocalContext.current)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(viewModelSmartLab)
                }
            }
        }
    }
}