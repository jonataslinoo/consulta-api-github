package com.example.consultaapigithub.di.modules

import com.example.consultaapigithub.retrofit.webclient.GitHubWebClient
import org.koin.dsl.module

val appModules = module {
    single<GitHubWebClient> {
        GitHubWebClient(get())
    }
}