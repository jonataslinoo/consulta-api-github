package com.example.consultaapigithub.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consultaapigithub.databinding.ActivityMainBinding
import com.example.consultaapigithub.model.ColecaoGit
import com.example.consultaapigithub.repository.ColecaoGitRepository
import com.example.consultaapigithub.ui.recyclerview.adapter.ColecaoGitAdapter
import com.example.consultaapigithub.ui.viewmodel.ColecaoGitViewModel
import com.example.consultaapigithub.ui.viewmodel.factory.ColecaoViewModelFactory

class ColecaoGitActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        val repository = ColecaoGitRepository()
        val factory = ColecaoViewModelFactory(repository)
        ViewModelProvider(this, factory).get(ColecaoGitViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        buscaColecaoGit()
    }

    private fun buscaColecaoGit() {
        viewModel.buscaColecaoGit(
            sucesso = {
                it?.let {
                    configuraList(it)
                }
            },
            falha = {
                Toast.makeText(this, it, Toast.LENGTH_LONG)
                    .show()
            })
    }

//    private fun buscaGitHub() {
//        GitHubWebClient().buscaGitHub(
//            sucesso = {
//                it?.run {
//                    configuraList(it.repositoriosGit)
//                    binding.txtTotalPaginas.text = it.total
//                }
//            },
//            falha = {
//                Toast.makeText(this, it, Toast.LENGTH_LONG)
//                    .show()
//            })
//    }

    private fun configuraList(colecaoList: List<ColecaoGit>) {
        val recyclerView = binding.recyclerviewList
        recyclerView.adapter = ColecaoGitAdapter(colecaoList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }
}
