package com.example.smartlab.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab.R
import com.example.smartlab.objects.CachePreferences
import com.example.smartlab.objects.RoutesScreens
import com.example.smartlab.ui.theme.GrayColor
import com.example.smartlab.ui.theme.GreenColor
import com.example.smartlab.ui.theme.SmartLabTheme

/** Приветственный экран*/
@Composable
fun OnBoard(navController: NavHostController?) {
    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(start = 30.dp, top = 30.dp)
                .clickable {
                    //при нажатии на кнопку изменяем статус
                    // в преференсе и переходим сл окно
                    CachePreferences.status = 1
                    navController!!.navigate(RoutesScreens.LOGIN){
                        popUpTo(RoutesScreens.ONBOARD) {
                            inclusive = true
                        }
                    }
                },
            text = "Пропустить",
            fontSize = 20.sp,
            color = Color(GreenColor.value)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 110.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(1f),
                textAlign = TextAlign.Center,
                text = "Анализы",
                fontSize = 20.sp,
                color = Color(GreenColor.value)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 30.dp),
                textAlign = TextAlign.Center,
                text = "Экспресс сбор и получение проб",
                fontSize = 14.sp,
                color = Color(GrayColor.value)
            )
        }
        Image(
            painter = painterResource(R.drawable.img_on_board_1),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 110.dp)
        )
    }
}

/*Для Preview*/
@Preview(showBackground = true)
@Composable
private fun Preview() {
    SmartLabTheme {
        OnBoard(null)
    }
}