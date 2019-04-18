package com.namget.logintest.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Job

abstract class BaseViewModel() : ViewModel() {

    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
    protected val jobs: ArrayList<Job> by lazy {
        arrayListOf<Job>()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}