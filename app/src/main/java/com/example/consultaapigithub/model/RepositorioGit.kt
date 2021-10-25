package com.example.consultaapigithub.model

import com.google.gson.annotations.SerializedName

class RepositorioGit(
//    @SerializedName("login")
//    val autor: String,
    @SerializedName("name")
    val nomeRepositorio: String,
//    @SerializedName("stargazers_count")
    @SerializedName("watchers")
    val qtdeEstrelas: String,
//    @SerializedName("forks_count")
    @SerializedName("forks")
    val qtdeBifurcacoes: String,
    @SerializedName("owner")
    val usuario: User
)