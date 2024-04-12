package com.example.smartlab.screens

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab.objects.RoutesScreens
import com.example.smartlab.ui.theme.GrayBorderColor
import com.example.smartlab.ui.theme.GrayColor
import com.example.smartlab.ui.theme.LightGrayColor
import com.example.smartlab.ui.theme.SmartLabTheme
import com.example.smartlab.ui.theme.Typography

@SuppressLint("UnrememberedMutableState")
@Composable
fun CreatingPatientCard(navHostController: NavHostController?) {
    var name = mutableStateOf("")
    var patronymic = mutableStateOf("")
    var surname = mutableStateOf("")
    var dateBirth = mutableStateOf("")
    var gender = mutableStateOf("")
    var expanded: Boolean
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(20.dp, 60.dp, 20.dp, 100.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Text(
                style = Typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth(0.55f),
                text = "Создание карты пациента"
            )
            Text(
                textAlign = TextAlign.End,
                text = "Пропустить",
                color = MaterialTheme.colorScheme.primary
            )
        }
        Text(
            text = "Без карты пациента вы не сможете заказать анализы.",
            fontSize = 14.sp,
            color = GrayColor
        )
        Text(
            text = "В картах пациентов будут храниться результаты анализов вас и ваших близких.",
            fontSize = 14.sp,
            color = GrayColor
        )
        OutlinedTextField(
            value = name.value,
            onValueChange = { newText -> name.value = newText },
            placeholder = {
                Text(
                    text = "Имя",
                    style = TextStyle(color = Color.Gray)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(LightGrayColor, shape = RoundedCornerShape(8.dp))
                .border(0.dp, GrayBorderColor, shape = RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(10.dp),
            maxLines = 1,
            singleLine = true
        )
        OutlinedTextField(
            value = patronymic.value,
            onValueChange = { newText -> patronymic.value = newText },
            placeholder = {
                Text(
                    text = "Отчество",
                    style = TextStyle(color = Color.Gray)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(LightGrayColor, shape = RoundedCornerShape(8.dp))
                .border(0.dp, GrayBorderColor, shape = RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(10.dp),
            maxLines = 1,
            singleLine = true
        )
        OutlinedTextField(
            value = surname.value,
            onValueChange = { newText -> surname.value = newText },
            placeholder = {
                Text(
                    text = "Фамилия",
                    style = TextStyle(color = Color.Gray)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(LightGrayColor, shape = RoundedCornerShape(8.dp))
                .border(0.dp, GrayBorderColor, shape = RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(10.dp),
            maxLines = 1,
            singleLine = true
        )
        OutlinedTextField(
            value = dateBirth.value,
            onValueChange = { newText -> dateBirth.value = newText },
            placeholder = {
                Text(
                    text = "Дата рождения",
                    style = TextStyle(color = Color.Gray)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(LightGrayColor, shape = RoundedCornerShape(8.dp))
                .border(0.dp, GrayBorderColor, shape = RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(10.dp),
            maxLines = 1,
            singleLine = true
        )
        DropdownMenu(
            expanded = false,
            onDismissRequest = { }
        ) {
            DropdownMenuItem(
                text = { Text("Мужской") },
                onClick = {  gender.value = "Мужской" }
            )
            DropdownMenuItem(
                text = { Text("Женский") },
                onClick = { gender.value = "Женский" }
            )
        }
        OutlinedTextField(
            value = gender.value,
            onValueChange = { newText -> gender.value = newText },
            placeholder = {
                Text(
                    text = "Пол",
                    style = TextStyle(color = Color.Gray)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(LightGrayColor, shape = RoundedCornerShape(8.dp))
                .border(0.dp, GrayBorderColor, shape = RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(10.dp),
            maxLines = 1,
            singleLine = true
        )
        Button(
            onClick = {  },
            enabled = name.value.isNotEmpty()
                    && patronymic.value.isNotEmpty()
                    && surname.value.isNotEmpty()
                    && dateBirth.value.isNotEmpty()
                    && gender.value.isNotEmpty(),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color(0xFFC9D4FB),
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .padding(top = 30.dp)
                .height(60.dp)
                .fillMaxWidth()
        )
        {
            Text(text = "Создать", fontSize = 17.sp, color = Color.White)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    SmartLabTheme {
        CreatingPatientCard(null)
    }
}