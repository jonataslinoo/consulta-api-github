package com.example.consultaapigithub.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.consultaapigithub.model.ColecaoGit
import com.example.consultaapigithub.repository.ColecaoGitRepository
import com.example.consultaapigithub.repository.Resource

class ColecaoGitViewModel(private val repository: ColecaoGitRepository) : ViewModel() {

    fun buscaTodos(): LiveData<Resource<List<ColecaoGit>?>> {
        return repository.buscaTodos()
    }
}