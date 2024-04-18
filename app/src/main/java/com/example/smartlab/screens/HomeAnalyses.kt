package com.example.smartlab.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab.models.Catalog
import com.example.smartlab.ui.theme.GrayWhiteColor
import com.example.smartlab.ui.theme.SmartLabTheme
import com.example.smartlab.viewModel.ViewModelMain
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeAnalyses(navHostController: NavHostController?, viewModel: ViewModelMain?){
    //получение catalog из api
    viewModel!!.getListCatalog()
    val catalogList = viewModel!!.catalog.collectAsState().value
    /** объект Context — предоставляет доступ к базовым функциям приложения в Android,
    таким как доступ к ресурсам, файловой системе, вызов активности и т. д.*/
    val context = LocalContext.current
    //Отслеживание ошибки
    LaunchedEffect(key1 = viewModel.showErrorToastChannel) {
        viewModel.showErrorToastChannel.collectLatest { show ->
            if (show) {
                Toast.makeText(
                    context, "Error", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(20.dp)
    )
    {
        catalogList.forEach {
            Log.d("Анализы", it.name)
        }
        PrintCatalog(catalogList)
    }
}

//Отрисовка каталога
@Composable
fun PrintCatalog(catalogList: List<Catalog>) {
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
    )
    {
        Text(
            modifier = Modifier
                .fillMaxWidth(1f),
            fontWeight = FontWeight.Bold,
            text = "Каталог анализов",
            fontSize = 17.sp,
            color = Color.Gray
        )
        //Если лист пустой, то будет отображаться progress bar
        if (catalogList.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            //Иначе выводим данные в лист
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(top = 16.dp)
            ) {
                items(catalogList.size) { index ->
                    ItemCatalog(catalogList[index])
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

//Отрисовка одного элемента каталога
@Composable
fun ItemCatalog(item: Catalog) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(GrayWhiteColor)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Text(
        modifier = Modifier.padding(16.dp),
        text = item.name,
        fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp, 0.dp, 16.dp, 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column()
            {
                Text(
                    text = item.timeResul,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = item.price.toString(),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                   containerColor = MaterialTheme.colorScheme.primary
                )
            )
            {
                Text(text = "Добавить",
                    fontSize = 14.sp,
                    color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SmartLabTheme {
        HomeAnalyses(null,null)
    }
}