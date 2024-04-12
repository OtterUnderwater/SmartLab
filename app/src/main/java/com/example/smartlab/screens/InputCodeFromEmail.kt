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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.smartlab.ui.theme.Typography


@Composable
fun InputCodeFromEmail(navHostController: NavHostController?) {
    var code by rememberSaveable { mutableStateOf("") }
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
      /*      OutlinedTextField(
                value = code.get(0).toString(),
                onValueChange = { newText -> code += newText },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(25f)
                    .height(48.dp)
                    .background(LightGrayColor, shape = RoundedCornerShape(8.dp))
                    .border(0.dp, GrayBorderColor, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(10.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )*/
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