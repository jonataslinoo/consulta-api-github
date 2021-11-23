package com.example.consultaapigithub.model

import com.google.gson.annotations.SerializedName

class ColecaoGit(
    @SerializedName("name")
    val nomeRepositorio: String,
    @SerializedName("watchers")
    val qtdeEstrelas: String,
    @SerializedName("forks")
    val qtdeBifurcacoes: String,
    @SerializedName("owner")
    val usuario: User
)