package com.example.consultaapigithub.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consultaapigithub.adapter.RepositorioGitAdapter
import com.example.consultaapigithub.databinding.ActivityMainBinding
import com.example.consultaapigithub.model.GitHub
import com.example.consultaapigithub.model.RepositorioGit
import com.example.consultaapigithub.retrofit.client.GitHubWebClient


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //faz a chamada do retrofit
//        GitHubWebClient().retornaDadosGit(
//            //recebe a resposta de sucesso
//            {
//                configuraList(it.repositoriosGit)
//                binding.txtTotalPaginas.text = it.total
//            },
//            //recebe a resposta de falha
//            {
//                Toast.makeText(this, "Falha ao buscar os dados do github.", Toast.LENGTH_LONG)
//                    .show()
//            })

        GitHubWebClient().retornaDadosGit { gitHub: GitHub?, throwable: Throwable? ->
            gitHub?.let {
                configuraList(it.repositoriosGit)
                binding.txtTotalPaginas.text = it.total
            }
            throwable?.let {
                Toast.makeText(this, "Falha ao buscar os dados do github.", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun configuraList(repositorioList: List<RepositorioGit>) {
        val recyclerView = binding.recyclerviewList
        recyclerView.adapter = RepositorioGitAdapter(repositorioList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }
}