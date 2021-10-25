package com.example.consultaapigithub.retrofit

import com.example.consultaapigithub.Constants.Companion.BASE_URL
import com.example.consultaapigithub.retrofit.service.GitHubService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInitializer {

    private fun client(): OkHttpClient =
        OkHttpClient.Builder()
            //O apply reotna o proprio objeto, aplicando as atribuições feitas dentro dele.
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

//   private fun gson(): Gson = GsonBuilder().create()

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client())
            .build()

    val gitHubService = retrofit.create(GitHubService::class.java)
}