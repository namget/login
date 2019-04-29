package com.namget.logintest.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {
    abstract val layoutId: Int
    abstract fun init()
    open protected lateinit var binding: B
    private val compositieDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        init()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        compositieDisposable.clear()
        super.onDestroy()

    }
}