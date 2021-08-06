package com.example.mycodingexercisev2.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRetrofit
{
    @Volatile
    private var code_retrofit: Retrofit? = null
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun getRequest() : Retrofit {
        return code_retrofit ?: synchronized(this) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                    .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            code_retrofit = retrofit
            retrofit
        }
    }

    fun<T> getServices(service: Class<T>): T {
        return getRequest().create(service)
    }
}