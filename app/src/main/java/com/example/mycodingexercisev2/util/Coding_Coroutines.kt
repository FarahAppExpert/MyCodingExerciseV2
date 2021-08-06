package com.example.mycodingexercisev2.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Coding_Coroutines {
    fun main(Coding: suspend (()->Unit)) {

        CoroutineScope(Dispatchers.Main).launch {

            Coding()
        }
    }
}