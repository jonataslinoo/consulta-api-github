package com.example.consultaapigithub.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.consultaapigithub.repository.ColecaoGitRepository
import com.example.consultaapigithub.ui.viewmodel.ColecaoGitViewModel

class ColecaoViewModelFactory(
    private val repository: ColecaoGitRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ColecaoGitViewModel(repository) as T
    }
}