package com.example.consultaapigithub.repository

import com.example.consultaapigithub.model.ColecaoGit
import com.example.consultaapigithub.retrofit.webclient.GitHubWebClient

class ColecaoGitRepository(
    private val webClient: GitHubWebClient = GitHubWebClient()
) {

    fun buscaTodos(
        sucesso: (colecaoGit: List<ColecaoGit>?) -> Unit,
        falha: (erro: String?) -> Unit
    ) {
        buscaNaApi(sucesso, falha)
    }

    private fun buscaNaApi(
        sucesso: (colecaoGit: List<ColecaoGit>?) -> Unit,
        falha: (erro: String?) -> Unit
    ) {
        webClient.buscaColecaoGit(
            sucesso = sucesso,
            falha = falha
        )
    }
}