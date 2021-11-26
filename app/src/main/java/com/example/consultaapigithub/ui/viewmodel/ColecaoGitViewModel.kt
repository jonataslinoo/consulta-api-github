package com.example.consultaapigithub.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.consultaapigithub.model.ColecaoGit
import com.example.consultaapigithub.model.ColecaoGitResponse
import com.example.consultaapigithub.model.GitHub
import com.example.consultaapigithub.repository.ColecaoGitRepository

class ColecaoGitViewModel(private val repository: ColecaoGitRepository) : ViewModel() {

    fun buscaColecaoGit(
        sucesso: (colecaoGit: ColecaoGitResponse?) -> Unit,
        falha: (erro: String?) -> Unit
    ) {
        repository.buscaTodos(sucesso, falha)
    }
}