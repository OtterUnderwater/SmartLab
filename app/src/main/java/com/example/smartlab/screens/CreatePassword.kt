package com.example.smartlab.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab.objects.CachePreferences
import com.example.smartlab.objects.RoutesScreens
import com.example.smartlab.ui.theme.GrayBorderColor
import com.example.smartlab.ui.theme.GrayColor
import com.example.smartlab.ui.theme.LightGrayColor
import com.example.smartlab.ui.theme.SmartLabTheme
import com.example.smartlab.ui.theme.Typography

@Composable
fun CreatePassword(navController: NavHostController?) {
    var password = rememberSaveable { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(44.dp, 50.dp, 44.dp, 80.dp)
    )
    {
        Text(
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController!!.navigate(RoutesScreens.CREATE_PATIENT_CARD){
                        popUpTo(RoutesScreens.CREATE_PASSWORD) {
                            inclusive = true
                        }
                    }
                },
            text = "Пропустить",
            color = colorScheme.primary
        )
       Text(
                modifier = Modifier
                    .fillMaxWidth(),
                style = Typography.titleLarge,
                textAlign = TextAlign.Center,
                text = "Создайте пароль"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                textAlign = TextAlign.Center,
                text = "Для защиты ваших персональных данных",
                fontSize = 15.sp,
                color = GrayColor
            )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 95.dp)
        ){
            Box(
                modifier = Modifier.size(16.dp)
                    .clip(CircleShape)
                    .background(colorScheme.primary)
            )
            Box(
                modifier = Modifier.size(16.dp)
                    .clip(CircleShape)
                    .background(colorScheme.primary)
            )
            Box(
                modifier = Modifier.size(16.dp)
                    .clip(CircleShape)
                    .background(colorScheme.primary)
            )
            Box(
                modifier = Modifier.size(16.dp)
                    .clip(CircleShape)
                    .background(colorScheme.primary)
            )

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = { password.value += "1" },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGrayColor
                )
            )
            {
                Text(
                    modifier = Modifier.padding(10.dp, 15.dp),
                    style = Typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = "1"
                )
            }
            Button(
                onClick = { password.value += "2" },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGrayColor
                )
            )
            {
                Text(
                    modifier = Modifier.padding(10.dp, 15.dp),
                    style = Typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = "2"
                )
            }
            Button(
                onClick = { password.value += "3" },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGrayColor
                )
            )
            {
                Text(
                    modifier = Modifier.padding(10.dp, 15.dp),
                    style = Typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = "3"
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = { password.value += "4" },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGrayColor
                )
            )
            {
                Text(
                    modifier = Modifier.padding(10.dp, 15.dp),
                    style = Typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = "4"
                )
            }
            Button(
                onClick = { password.value += "5" },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGrayColor
                )
            )
            {
                Text(
                    modifier = Modifier.padding(10.dp, 15.dp),
                    style = Typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = "5"
                )
            }
            Button(
                onClick = { password.value += "6" },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGrayColor
                )
            )
            {
                Text(
                    modifier = Modifier.padding(10.dp, 15.dp),
                    style = Typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = "6"
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = { password.value += "7" },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGrayColor
                )
            )
            {
                Text(
                    modifier = Modifier.padding(10.dp, 15.dp),
                    style = Typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = "7"
                )
            }
            Button(
                onClick = { password.value += "8" },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGrayColor
                )
            )
            {
                Text(
                    modifier = Modifier.padding(10.dp, 15.dp),
                    style = Typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = "8"
                )
            }
            Button(
                onClick = { password.value += "9" },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGrayColor
                )
            )
            {
                Text(
                    modifier = Modifier.padding(10.dp, 15.dp),
                    style = Typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = "9"
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Button(
                onClick = { password.value += "0" },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGrayColor)
            )
            {
                Text(
                    modifier = Modifier.padding(10.dp, 15.dp),
                    style = Typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = "0")
            }
        }




    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    SmartLabTheme {
        CreatePassword(null)
    }
}