package com.namget.logintest.ui.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namget.logintest.ui.base.BaseApplicationViewModel

class LoginViewModel(val mApplication: Application) : BaseApplicationViewModel(mApplication) {

    private val _idText = MutableLiveData<String>()
    val idText: LiveData<String> get() = _idText
    private val _passwordText = MutableLiveData<String>()
    val passwordText: LiveData<String> get() = _passwordText


    //제목 textwatcher
    fun onIdTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _idText.value = s.toString()
    }

    fun onPasswordTextChange(s: CharSequence, start: Int, before: Int, count: Int) {
        _passwordText.value = s.toString()
    }


}