package com.example.mycodingexercisev2.api


import com.example.mycodingexercisev2.model.CodingModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("//jsonplaceholder.typicode.com/albums")
    suspend fun getList(): Response<List<CodingModel>>
}