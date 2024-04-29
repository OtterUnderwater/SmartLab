package com.example.smartlab.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab.models.Catalog
import com.example.smartlab.objects.RoutesScreens
import com.example.smartlab.ui.theme.GrayColor
import com.example.smartlab.ui.theme.SmartLabTheme
import com.example.smartlab.ui.theme.Typography
import com.example.smartlab.viewModel.ViewModelMain
import kotlinx.coroutines.flow.collectLatest


@Composable
fun CardProduct(navHostController: NavHostController?, viewModel: ViewModelMain?) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(20.dp)
    )
    {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            style = Typography.titleLarge,
            textAlign = TextAlign.Center,
            text = "Клинический анализ крови с лейкоцитарной формулой",
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            style = Typography.titleSmall,
            text = "Описание",
            fontSize = 17.sp,
            color = GrayColor
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            style = Typography.titleSmall,
            text = "Подготовка",
            fontSize = 17.sp,
            color = GrayColor
        )
        Row(
            modifier = Modifier
            .fillMaxWidth(1f)
        ){
            Text(
                modifier = Modifier.weight(0.5f),
                style = Typography.titleSmall,
                text = "Результаты через:",
                fontSize = 17.sp,
                color = GrayColor
            )
            Text(
                modifier = Modifier.weight(0.5f),
                style = Typography.titleSmall,
                text = "Биоматериал:",
                fontSize = 17.sp,
                color = GrayColor
            )
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color(0xFFC9D4FB),
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
        )
        {
            Text(text = "Добавить за ... ₽", fontSize = 17.sp, color = Color.White)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    SmartLabTheme {
        CardProduct(null, null)
    }
}