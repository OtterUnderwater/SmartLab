package com.example.smartlab.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartlab.objects.RoutesScreens
import com.example.smartlab.screens.OnBoard
import com.example.smartlab.screens.SplashScreen

/*Класс для перемещения по страницам
* В данном класе прописываются все траницы и их путь*/
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,//контроллер реагирующий и отвечающий за перемещения
        startDestination = RoutesScreens.SPLASH
    )
    {
        //Для каждой страницы задается route - для дальнейшего обращения к ней
        //и указывается метод для запуска с переданными параметрами
        composable(RoutesScreens.SPLASH) {
            SplashScreen(navController)
        }
        composable(RoutesScreens.ONBOARD) {
            OnBoard(navController)
        }
       /* composable(RoutesScreens.LOGIN) {
            LogIn(navController)
        }*/
    }
}