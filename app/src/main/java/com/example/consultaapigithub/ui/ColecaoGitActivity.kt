package com.example.consultaapigithub.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consultaapigithub.databinding.ActivityMainBinding
import com.example.consultaapigithub.model.ColecaoGit
import com.example.consultaapigithub.repository.ColecaoGitRepository
import com.example.consultaapigithub.ui.extensions.mostraErro
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
        viewModel.buscaColecaoGit().observe(this, Observer { resource ->
            resource.dado?.let { configuraList(it) }
            resource.erro?.let { mostraErro(it) }
        })
    }

    private fun configuraList(colecaoList: List<ColecaoGit>) {
        val recyclerView = binding.recyclerviewList
        recyclerView.adapter = ColecaoGitAdapter(colecaoList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }
}
