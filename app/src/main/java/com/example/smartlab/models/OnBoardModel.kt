package com.example.smartlab.models

//Модель для очереди (экраны у входа)
data class OnBoardModel(
    var name: String,
    var description: String,
    var image: Int,
    var act: Int
)