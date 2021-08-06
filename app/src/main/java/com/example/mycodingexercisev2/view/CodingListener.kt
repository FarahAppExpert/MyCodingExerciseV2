package com.example.mycodingexercisev2.view

import com.example.mycodingexercisev2.model.CodingModel


interface CodingListener {
    fun onItemClick(flowerModel: CodingModel)
    fun onFailure(message: String)
}