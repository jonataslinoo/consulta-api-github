package com.example.consultaapigithub.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.consultaapigithub.model.ColecaoGit
import com.example.consultaapigithub.retrofit.webclient.GitHubWebClient

class ColecaoGitRepository(
    private val webClient: GitHubWebClient = GitHubWebClient()
) {
    private val colecaoGitEncontrada = MutableLiveData<Resource<List<ColecaoGit>?>>()

    fun buscaTodos(): LiveData<Resource<List<ColecaoGit>?>> {
        buscaNaApi(sucesso = {
            colecaoGitEncontrada.value = Resource(dado = it)
        }, falha = {
            val resourceAtual = colecaoGitEncontrada.value
            val resourceCriado: Resource<List<ColecaoGit>?> =
                if (resourceAtual != null) {
                    Resource(dado = resourceAtual.dado, erro = it)
                } else {
                    Resource(dado = null, erro = it)
                }
            colecaoGitEncontrada.value = resourceCriado
        })
        return colecaoGitEncontrada
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