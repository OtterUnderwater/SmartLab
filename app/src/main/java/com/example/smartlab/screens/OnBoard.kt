package com.example.smartlab.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab.R
import com.example.smartlab.models.OnBoardModel
import com.example.smartlab.objects.CachePreferences
import com.example.smartlab.objects.RoutesScreens
import com.example.smartlab.ui.theme.GrayColor
import com.example.smartlab.ui.theme.GreenColor
import com.example.smartlab.ui.theme.LightBlueColor
import com.example.smartlab.ui.theme.SmartLabTheme
import java.util.LinkedList
import java.util.Queue

/** Приветственный экран*/
@Composable
fun OnBoard(navController: NavHostController?) {
    //Заполнение очереди
    val queue by remember {
        mutableStateOf(
            LinkedList(
                listOf(
                    OnBoardModel(
                        "Анализы",
                        "Экспресс сбор и получение проб",
                        R.drawable.img_on_board_1,
                        1
                    ),
                    OnBoardModel(
                        "Уведомления",
                        "Вы быстро узнаете о результатах",
                        R.drawable.img_on_board_2,
                        2
                    ),
                    OnBoardModel(
                        "Мониторинг",
                        "Наши врачи всегда наблюдают за вашими показателями здоровья",
                        R.drawable.img_on_board_3,
                        3
                    ),
                )
            )
        )
    }

    var currentModel by remember {
        mutableStateOf(queue.poll())
    }
    var idMainImg by remember {
        mutableIntStateOf(value = currentModel.image)
    }
    var tTittle by remember {
        mutableStateOf(value = currentModel.name)
    }
    var tDescription by remember {
        mutableStateOf(value = currentModel.description)
    }
    var act by remember {
        mutableIntStateOf(currentModel.act)
    }
    var queueIsEmpty by remember {
        mutableStateOf(queue.size == 0)
    }

    //Эта штука будет срабатывать при каждом изменении currentModel
    LaunchedEffect(key1 = currentModel) {
        idMainImg = currentModel.image
        tTittle = currentModel.name
        tDescription = currentModel.description
        act = currentModel.act
        queueIsEmpty = queue.size == 0
    }

    //Установка значений из очереди на активность
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
    ) {
        if (!queueIsEmpty) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(start = 30.dp, top = 30.dp)
                    .clickable {
                        currentModel = queue.poll()
                    },
                text = "Пропустить",
                fontSize = 20.sp,
                color = Color(GreenColor.value)
            )
        }
        else {
            Text(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(start = 30.dp, top = 30.dp)
                    .clickable {
                        if (queue.size == 0) {
                            //изменяем статус в преференсе и переходим на следующее окно
                            CachePreferences.status = 1
                            navController!!.navigate(RoutesScreens.LOGIN) {
                                //Удаляет экран чтобы запретить к нему возвращаться
                                popUpTo(RoutesScreens.ONBOARD) {
                                    inclusive = true
                                }
                            }
                        }
                    },
                text = "Завершить",
                fontSize = 20.sp,
                color = Color(GreenColor.value)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 110.dp)
        ) {
          Text(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    textAlign = TextAlign.Center,
                    text = tTittle,
                    fontSize = 20.sp,
                    color = Color(GreenColor.value)
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 30.dp),
                    textAlign = TextAlign.Center,
                    text =  tDescription,
                    fontSize = 14.sp,
                    color = Color(GrayColor.value)
                )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 155.dp, vertical = 50.dp)
            ){
                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .clip(CircleShape)
                        .background(if (queue.size == 2) LightBlueColor else Color.Transparent)
                        .border(1.dp, LightBlueColor)
                )
                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .clip(CircleShape)
                        .background(if (queue.size == 1) LightBlueColor else Color.Transparent)
                        .border(1.dp, LightBlueColor)
                )
                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .clip(CircleShape)
                        .background(if (queue.size == 0) LightBlueColor else Color.Transparent)
                        .border(1.dp, LightBlueColor)
                )
            }
            Image(
                painter = painterResource(id = idMainImg),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxHeight(0.75f)
                    .fillMaxWidth(1f)
                    .padding(top = 110.dp)
            )
        }
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