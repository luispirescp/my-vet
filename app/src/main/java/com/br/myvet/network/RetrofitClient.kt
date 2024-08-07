package com.br.myvet.network

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object RetrofitClient {


    private  const val BASE_URL = "http://10.0.2.2:5000"
    private val retrofit by lazy {
        println("chamando base")
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }
    fun getCliente(): Retrofit {
        return retrofit
    }
}