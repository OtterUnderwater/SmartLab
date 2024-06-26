package com.example.smartlab.screens

import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab.objects.RoutesScreens
import com.example.smartlab.ui.theme.GrayBorderColor
import com.example.smartlab.ui.theme.LightGrayColor
import com.example.smartlab.ui.theme.SmartLabTheme
import com.example.smartlab.ui.theme.Typography
import com.example.smartlab.viewModel.ViewModelMain

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputCodeFromEmail(navHostController: NavHostController?, viewModel: ViewModelMain?) {
    //mutableStateOf() создает изменяемое состояние с нач значением
    var code: MutableList<String> = remember { mutableStateListOf("", "", "", "") }
    var time = remember { mutableStateOf(60) }
    var focusManager = LocalFocusManager.current

    //Перемещение фокуса между ячейками
    fun moveFocusToNextField(index: Int) {
        if (index < code.size - 1) {
            focusManager.moveFocus(FocusDirection.Next)
        } else {
            focusManager.clearFocus()
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(horizontal = 70.dp)
    )
    {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            style = Typography.titleLarge,
            textAlign = TextAlign.Center,
            text = "Введите код из E-mail",
            fontSize = 17.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = code[0],
                onValueChange = { newText ->
                    if (newText.length == 1) {
                        code[0] = newText
                        moveFocusToNextField(0)
                    } else {
                        code[0] = ""
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(25f)
                    .height(48.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = LightGrayColor,
                    unfocusedBorderColor = GrayBorderColor
                ),
                shape = RoundedCornerShape(10.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = code[1],
                onValueChange = { newText ->
                    if (newText.length == 1)
                    {
                        code[1] = newText
                        moveFocusToNextField(1)
                    }
                    else {
                        code[1] = ""
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(25f)
                    .height(48.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = LightGrayColor,
                    unfocusedBorderColor = GrayBorderColor
                ),
                shape = RoundedCornerShape(10.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = code[2],
                onValueChange = { newText ->
                    if (newText.length == 1)
                    {
                        code[2] = newText
                        moveFocusToNextField(1)
                    }
                    else {
                        code[2] = ""
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(25f)
                    .height(48.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = LightGrayColor,
                unfocusedBorderColor = GrayBorderColor
            ),
                shape = RoundedCornerShape(10.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = code[3],
                onValueChange = { newText ->
                    if (newText.length == 1)
                    {
                        code[3] = newText
                        moveFocusToNextField(3)
                        viewModel!!.checkCodeAndEmail(code, navHostController!!) //запрос к апи
                    }
                    else {
                        code[3] = ""
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(25f)
                    .height(48.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = LightGrayColor,
                    unfocusedBorderColor = GrayBorderColor
                ),
                shape = RoundedCornerShape(10.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            textAlign = TextAlign.Center,
            text = "Отправить код повторно можно будет через ${time.value} секунд",
            fontSize = 15.sp, color = Color.Gray
        )
    }

    // Создание таймера обратного отсчета
    // Подробнее - https://developer.android.com/reference/android/os/CountDownTimer
    val timer = object : CountDownTimer(60000, 1000) {
         override fun onTick(millisUntilFinished: Long) {
             time.value = (millisUntilFinished / 1000).toInt()
         }
        override fun onFinish() {}
    }

    // Запуск таймера
    LaunchedEffect(Unit) {
        timer.start()
    }
}


/*Для Preview*/
@Preview(showBackground = true)
@Composable
private fun Preview() {
    SmartLabTheme {
        InputCodeFromEmail(null, null)
    }
}