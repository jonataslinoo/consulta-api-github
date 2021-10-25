package com.example.consultaapigithub.retrofit.client

import com.example.consultaapigithub.model.GitHub
import com.example.consultaapigithub.retrofit.RetrofitInitializer
import com.example.consultaapigithub.retrofit.callback
import retrofit2.Response

class GitHubWebClient {

//    fun retornaDadosGit(
//        success: (gitHub: GitHub) -> Unit, failure: (throwable: Throwable) -> Unit
//    ) {
//        val call = RetrofitInitializer().gitHubService.getDataGitHub()
//
//        call.enqueue(callback { response, throwable ->
//            // Disponibiliza a resposta de sucesso para quem chama
//            response?.let { response ->
//                response.body()?.let {
//                    success(it)
//                }
//            }
//            // Disponibiliza a resposta de falha para quem chama
//            throwable?.let {
//                failure(it)
//            }
//        })
//    }

    fun retornaDadosGit(
        callResponse: (gitHub: GitHub?,
                       throwable: Throwable? ) -> Unit) {

        val call = RetrofitInitializer().gitHubService.getDataGitHub()

        call.enqueue(callback { response, throwable ->
            // Disponibiliza a resposta de sucesso para quem chama
            response?.let(fun(response: Response<GitHub>): Unit? {
                return response.body()?.let {
                    callResponse(it, null)
                }
            })
            // Disponibiliza a resposta de falha para quem chama
            throwable?.let {
                callResponse(null, it)
            }
        })
    }
}