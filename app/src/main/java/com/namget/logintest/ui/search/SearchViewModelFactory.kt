package com.namget.logintest.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.namget.logintest.data.repository.Repository
import com.namget.logintest.util.Logger

@Suppress("UNCHECKED_CAST")
class SearchViewModelFactory(private val repository: Repository , private val logger : Logger) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(repository, logger) as T
    }
}