package com.example.consultaapigithub.retrofit.service

import com.example.consultaapigithub.Constants.Companion.TOKEN
import com.example.consultaapigithub.model.GitHub
import com.example.consultaapigithub.model.RepositorioGit
import com.example.consultaapigithub.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GitHubService {

    @GET("/search/repositories?q=language:kotlin&sort=stars&page=1")
    @Headers("Authorization: token $TOKEN")
    fun getDataGitHub(): Call<GitHub>

    @GET("search/users")
    @Headers("Authorization: token $TOKEN")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>
}