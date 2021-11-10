package com.example.consultaapigithub.di.modules

import com.example.consultaapigithub.retrofit.client.GitHubWebClient
import org.koin.dsl.module

val appModules = module {
    single<GitHubWebClient> {
        GitHubWebClient(get())
    }
}