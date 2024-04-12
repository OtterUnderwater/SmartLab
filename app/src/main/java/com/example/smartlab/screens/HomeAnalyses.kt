package com.example.smartlab.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.smartlab.ui.theme.SmartLabTheme

@Composable
fun HomeAnalyses(navHostController: NavHostController?){

}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SmartLabTheme {
        HomeAnalyses(null)
    }
}