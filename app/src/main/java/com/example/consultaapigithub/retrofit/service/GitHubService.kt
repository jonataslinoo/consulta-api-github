package com.example.consultaapigithub.retrofit.service

import com.example.consultaapigithub.model.ColecaoGit
import com.example.consultaapigithub.model.ColecaoGitResponse
import com.example.consultaapigithub.model.GitHub
import com.example.consultaapigithub.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {

    @GET("/search/repositories?q=language:kotlin&sort=stars&page=1")
//    @Headers("Authorization: token $TOKEN")
    fun getDataGitHub(): Call<GitHub>

    @GET("/search/repositories?q=language:kotlin&sort=stars&page=1")
    fun buscaColecaoGit(): Call<ColecaoGitResponse>
//    fun buscaColecaoGit(): Call<List<ColecaoGit>>

    @GET("search/users")
//    @Headers("Authorization: token $TOKEN")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>
}