package com.example.consultaapigithub.repository

class Resource<T>(
    val dado: T?,
    val erro: String? = null
)