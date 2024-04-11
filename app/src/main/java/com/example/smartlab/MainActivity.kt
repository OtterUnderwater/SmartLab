package com.example.smartlab

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.smartlab.navigation.Navigation
import com.example.smartlab.objects.CachePreferences
import com.example.smartlab.ui.theme.SmartLabTheme

/** Из главной активности просто вызываем
 * Navigation() для переключения между страницами*/
class MainActivity : ComponentActivity() {
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
                    Navigation()
                }
            }
        }
    }
}