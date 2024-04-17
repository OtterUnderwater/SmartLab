package com.example.smartlab.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartlab.objects.RoutesScreens
import com.example.smartlab.screens.CreatePassword
import com.example.smartlab.screens.CreatingPatientCard
import com.example.smartlab.screens.HomeAnalyses
import com.example.smartlab.screens.InputCodeFromEmail
import com.example.smartlab.screens.LogIn
import com.example.smartlab.screens.OnBoard
import com.example.smartlab.screens.SplashScreen
import com.example.smartlab.viewModel.ViewModelMain

/*Класс для перемещения по страницам
* В данном класе прописываются все траницы и их путь*/
@Composable
fun Navigation(viewModel: ViewModelMain) {
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
        composable(RoutesScreens.LOGIN) {
            LogIn(navController, viewModel)
        }
        composable(RoutesScreens.CODEEMAIL) {
            InputCodeFromEmail(navController)
        }
        composable(RoutesScreens.CREATEPASSWORD) {
            CreatePassword(navController)
        }
        composable(RoutesScreens.CREATEPATIENTCARD) {
            CreatingPatientCard(navController)
        }
        composable(RoutesScreens.HOMEANALYSES) {
            HomeAnalyses(navController)
        }
    }
}