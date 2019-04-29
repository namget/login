package com.namget.logintest.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namget.logintest.ui.base.BaseViewModel

class SearchViewModel : BaseViewModel() {

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> get() = _isLoading

}