package com.namget.logintest.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Job

abstract class BaseApplicationViewModel(application: Application) : AndroidViewModel(application) {

    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
    protected val jobs: ArrayList<Job> by lazy {
        arrayListOf<Job>()
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}