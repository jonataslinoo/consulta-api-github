package com.example.consultaapigithub.repository

import com.example.consultaapigithub.model.ColecaoGit
import com.example.consultaapigithub.model.ColecaoGitResponse
import com.example.consultaapigithub.model.GitHub
import com.example.consultaapigithub.retrofit.webclient.GitHubWebClient

class ColecaoGitRepository(
    private val webClient: GitHubWebClient = GitHubWebClient()
) {

    fun buscaTodos(
        sucesso: (colecaoGit: ColecaoGitResponse?) -> Unit,
        falha: (erro: String?) -> Unit
    ) {
        buscaNaApi(sucesso, falha)
    }

    private fun buscaNaApi(
        sucesso: (colecaoGit: ColecaoGitResponse?) -> Unit,
        falha: (erro: String?) -> Unit
    ) {
        webClient.buscaColecaoGit(
            sucesso = sucesso,
            falha = falha
        )
    }
}