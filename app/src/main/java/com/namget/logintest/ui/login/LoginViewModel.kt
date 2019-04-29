package com.namget.logintest.ui.login

import android.app.Application
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namget.logintest.ui.base.BaseApplicationViewModel
import com.namget.logintest.util.Event

class LoginViewModel(val mApplication: Application) : BaseApplicationViewModel(mApplication) {

    private val _idText = MutableLiveData<String>()
    val idText: LiveData<String> get() = _idText
    private val _passwordText = MutableLiveData<String>()
    val passwordText: LiveData<String> get() = _passwordText

    private val _event = MutableLiveData<Event<String>>()
    val event: LiveData<Event<String>> get() = _event


    //제목 textwatcher
    fun onIdTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _idText.value = s.toString()
    }

    fun onPasswordTextChange(s: CharSequence, start: Int, before: Int, count: Int) {
        _passwordText.value = s.toString()
    }

    fun loginButtonClick(view: View) {
        _event.value = Event("Search")
    }


}