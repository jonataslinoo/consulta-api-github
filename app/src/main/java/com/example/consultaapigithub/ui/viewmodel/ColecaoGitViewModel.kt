package com.example.consultaapigithub.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.consultaapigithub.model.ColecaoGit
import com.example.consultaapigithub.repository.ColecaoGitRepository

class ColecaoGitViewModel(private val repository: ColecaoGitRepository) : ViewModel() {

    fun buscaColecaoGit(
        sucesso: (colecaoGit: List<ColecaoGit>?) -> Unit,
        falha: (erro: String?) -> Unit
    ) {
        repository.buscaTodos(sucesso, falha)
    }
}