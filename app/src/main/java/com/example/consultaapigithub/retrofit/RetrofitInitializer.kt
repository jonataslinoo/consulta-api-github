package com.example.consultaapigithub.retrofit

import com.example.consultaapigithub.Constants.Companion.BASE_URL
import com.example.consultaapigithub.retrofit.service.GitHubService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val client by lazy {
        OkHttpClient.Builder()
            //O apply reotna o proprio objeto, aplicando as atribuições feitas dentro dele.
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val gitHubService: GitHubService by lazy {
        retrofit.create(GitHubService::class.java)
    }
}
