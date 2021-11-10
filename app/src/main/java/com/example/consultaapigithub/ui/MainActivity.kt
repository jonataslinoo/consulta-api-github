package com.example.consultaapigithub.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consultaapigithub.adapter.RepositorioGitAdapter
import com.example.consultaapigithub.databinding.ActivityMainBinding
import com.example.consultaapigithub.model.RepositorioGit
import com.example.consultaapigithub.retrofit.client.GitHubWebClient
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        GitHubWebClient().retornaDadosGit(
            sucesso = {
                it?.run {
                    configuraList(it.repositoriosGit)
                    binding.txtTotalPaginas.text = it.total
                }
            },
            falha = {
                Toast.makeText(this, it, Toast.LENGTH_LONG)
                    .show()
            })
    }

    private fun configuraList(repositorioList: List<RepositorioGit>) {
        val recyclerView = binding.recyclerviewList
        recyclerView.adapter = RepositorioGitAdapter(repositorioList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }
}
