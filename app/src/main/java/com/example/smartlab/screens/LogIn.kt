package com.example.smartlab.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab.objects.RoutesScreens
import com.example.smartlab.ui.theme.GrayBorderColor
import com.example.smartlab.ui.theme.LightGrayColor
import com.example.smartlab.ui.theme.SmartLabTheme
import com.example.smartlab.viewModel.ViewModelMain

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogIn(navHostController: NavHostController?, viewModel: ViewModelMain?) {
    //remember сохраняет значение во время перерисовки экрана
    //rememberSaveable сохраняет состояние еще и при перезапуске приложения
    //mutableStateOf() создает изменяемое состояние с нач значением
    //by вместо = чтобы вместо email.value писать email
    var email by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(5f)
            .padding(20.dp, 100.dp)
    )
    {
        Column(modifier = Modifier.weight(1f))
        {
            Text(
                modifier = Modifier.fillMaxWidth(1f),
                text = "✋ Добро пожаловать!",
                fontWeight = FontWeight.Bold, fontSize = 24.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 23.dp),
                text = "Войдите, чтобы пользоваться функциями приложения", fontSize = 15.sp
            )
        }
        Column(modifier = Modifier.weight(1f))
        {

            Text(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(bottom = 5.dp),
                text = "Вход по E-mail", fontSize = 14.sp, color = Color.Gray
            )
            OutlinedTextField(
                value = email,
                onValueChange = { newText -> email = newText },
                placeholder = {Text(
                    text = "example@mail",
                    style = TextStyle(color = Color.Gray))
                },
                modifier = Modifier
                    .fillMaxWidth(),
                //Изменение цвета контейнера и рамки
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = LightGrayColor,
                    unfocusedBorderColor = GrayBorderColor
                ),
                shape = RoundedCornerShape(10.dp),
                maxLines = 1,
                singleLine = true
            )
            Button(
                onClick = {
                    viewModel!!.sendCodeToEmail(email) //запрос к апи
                    navHostController!!.navigate(RoutesScreens.CODE_EMAIL)
                          },
                //Кнопка не активна пока не ввели email
                enabled = email.isNotEmpty(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    disabledContainerColor = Color(0xFFC9D4FB),
                    containerColor = colorScheme.primary
                ),
                modifier = Modifier
                    .padding(top = 30.dp)
                    .height(60.dp)
                    .fillMaxWidth()
            )
            {
                Text(text = "Далее", fontSize = 17.sp, color = Color.White)
            }
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(2f)
        ) {
            Text(
                text = "Или войдите с помощью",
                fontSize = 15.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(
                    1.dp, color = Color(0xFFEBEBEB)
                )
            ) {
                Text(text = "Войти с Яндекс", fontSize = 17.sp, color = Color.Black)
            }
        }
    }
}

/*Для Preview*/
@Preview(showBackground = true)
@Composable
private fun Preview() {
    SmartLabTheme {
        LogIn(null, null)
    }
}