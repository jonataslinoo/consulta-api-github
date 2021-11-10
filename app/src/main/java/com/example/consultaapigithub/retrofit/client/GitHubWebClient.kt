package com.example.consultaapigithub.retrofit.client

import com.example.consultaapigithub.model.GitHub
import com.example.consultaapigithub.retrofit.RetrofitInitializer
import com.example.consultaapigithub.retrofit.service.GitHubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubWebClient(
    private val service: GitHubService = RetrofitInitializer().gitHubService
) {

    private fun <T> executaRequisicao(
        call: Call<T>,
        sucesso: (noticiasNovas: T?) -> Unit,
        falha: (erro: String?) -> Unit
    ) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    sucesso(response.body())
                } else {
//                    falha(Constants.REQUISICAO_NAO_SUCEDIDA)
                    falha(response.errorBody()?.string())
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                falha(t.message)
            }
        })
    }

    fun retornaDadosGit(
        sucesso: (gitHub: GitHub?) -> Unit,
        falha: (erro: String?) -> Unit
    ) {
        executaRequisicao(
            service.getDataGitHub(),
            sucesso,
            falha
        )

    }
}