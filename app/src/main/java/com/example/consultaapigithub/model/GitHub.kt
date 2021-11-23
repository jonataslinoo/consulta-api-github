package com.example.consultaapigithub.model

import com.google.gson.annotations.SerializedName

data class GitHub(
    @SerializedName("total_count")
    val total: String,
    @SerializedName("items")
    val repositoriosGit : List<ColecaoGit>
)
