package com.example.mycodingexercisev2.repository

import com.example.mycodingexercisev2.api.ApiInterface
import com.example.mycodingexercisev2.api.ApiRetrofit
import com.example.mycodingexercisev2.model.CodingModel
import retrofit2.Response

class Coding_Repository() {
    suspend fun getCodeList(): Response<List<CodingModel>> {
        return ApiRetrofit.getServices(ApiInterface::class.java).getList()
    }
}