package com.example.smartlab.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.smartlab.R
import com.example.smartlab.objects.CachePreferences
import com.example.smartlab.objects.RoutesScreens
import com.example.smartlab.ui.theme.SmartLabTheme
import kotlinx.coroutines.delay

/** Загрузочный экран. Отображается 1,5 секунды с помощью задержки (delay(1500L))\
 * и переключается на следующий экран navController!!.navigate(RoutesScreens.LOGIN)*/
@Composable
fun SplashScreen(navController: NavHostController?) {
    //Получаем текущую конфигурацию телефона
    val configuration = LocalConfiguration.current
    //Проверка что ориентация телефона вертикальная
    if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        /*Функция LaunchedEffect используется для запуска сопрограммы (coroutine) при
       инициализации композиции. Это позволяет выполнить асинхронную операцию в момент
       создания компонента без блокирования главного потока пользовательского интерфейса.*/
        LaunchedEffect(key1 = true) {
            delay(1500L)
            //Проверяем PrefManager (Кэш приложения)
            // и в зависимости от статуса пользователя выбираем какой экран ему показывать
            if(CachePreferences.status == 0){
                navController!!.navigate(RoutesScreens.ONBOARD) {
                    //удаляет экран, чтобы не было возможности вернуться
                    popUpTo(RoutesScreens.SPLASH) {
                        inclusive = true
                    }
                }
            }
            if (CachePreferences.status == 1){
                navController!!.navigate(RoutesScreens.LOGIN) {
                    popUpTo(RoutesScreens.SPLASH) {
                        inclusive = true
                    }
                }
            }
        }
        //Заставка
        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight()
                .wrapContentWidth()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(0xFF74C8E4),
                            Color(0xFF73D5BC),
                            Color(0xFF74C8E4)
                        )
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(0x0D6269F0),
                                Color(0xA63740F5),
                                Color(0xFF2254F5),
                                Color(0xA63740F5),
                                Color(0x0D6269F0)
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_smart_lab),
                    contentDescription = "namelogo",
                    modifier = Modifier
                        .fillMaxSize(1f)
                        .padding(50.dp)
                )
            }
        }
    }
}

/*Для Preview*/
@Preview(showBackground = true)
@Composable
private fun Preview(){
    SmartLabTheme {
        SplashScreen(null)
    }
}