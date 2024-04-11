package com.example.smartlab.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab.ui.theme.GrayBorderColor
import com.example.smartlab.ui.theme.LightGrayColor
import com.example.smartlab.ui.theme.SmartLabTheme


@Composable
fun InputCodeFromEmail(navHostController: NavHostController?) {
    val code = rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(70.dp, 200.dp, 70.dp, 0.dp)
    )
    {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            textAlign = TextAlign.Center,
            text = "Введите код из E-mail", fontSize = 17.sp,
            fontStyle = FontStyle.Normal, color = Color.Black
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = code.value,
                onValueChange = { newText -> code.value = newText },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(25f)
                    .height(48.dp)
                    .background(LightGrayColor, shape = RoundedCornerShape(8.dp))
                    .border(0.dp, GrayBorderColor, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(10.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = code.value,
                onValueChange = { newText -> code.value = newText },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(25f)
                    .height(48.dp)
                    .background(LightGrayColor, shape = RoundedCornerShape(8.dp))
                    .border(0.dp, GrayBorderColor, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(10.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = code.value,
                onValueChange = { newText -> code.value = newText },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(25f)
                    .height(48.dp)
                    .background(LightGrayColor, shape = RoundedCornerShape(8.dp))
                    .border(0.dp, GrayBorderColor, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(10.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = code.value,
                onValueChange = { newText -> code.value = newText },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(25f)
                    .height(48.dp)
                    .background(LightGrayColor, shape = RoundedCornerShape(8.dp))
                    .border(0.dp, GrayBorderColor, shape = RoundedCornerShape(8.dp)),
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
            text = "Отправить код повторно можно будет через 59 секунд",
            fontSize = 15.sp, color = Color.Gray
        )
    }
}

/*Для Preview*/
@Preview(showBackground = true)
@Composable
private fun Preview() {
    SmartLabTheme {
        InputCodeFromEmail(null)
    }
}