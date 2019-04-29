package com.namget.logintest.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.namget.logintest.R
import com.namget.logintest.databinding.ActivityLoginBinding
import com.namget.logintest.ui.base.BaseActivity
import com.namget.logintest.ui.search.SearchActivity
import com.namget.logintest.util.hasSpecialCharacter
import com.namget.logintest.util.isMaximumLength
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_login
    private val loginViewModelFactory: LoginViewModelFactory by inject()
    private lateinit var loginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        initViewModel()

    }

    override fun init() {
    }

    override fun onStart() {
        super.onStart()
    }

    fun initViewModel() {
        loginViewModel = ViewModelProviders.of(this, loginViewModelFactory).get(LoginViewModel::class.java)
        binding.loginViewModel = loginViewModel
        binding.loginActivity = this

        loginViewModel.idText.observe(this, Observer {
            if (it.hasSpecialCharacter() or it.isMaximumLength(textInputId)) {
                textInputId.error = "특수문자를 입력하거나 최대 허용글자를 넘었습니다."
                textInputButton.isEnabled = false
            } else {
                textInputButton.isEnabled = true
                textInputId.error = null
            }
        })
        loginViewModel.passwordText.observe(this, Observer {

            if (it.isMaximumLength(textInputPassword)) {
                textInputPassword.error = "최대 허용글자를 넘었습니다."
                textInputButton.isEnabled = false
            } else {
                textInputButton.isEnabled = true
                textInputId.error = null
            }
        })

        loginViewModel.event.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                val Intent = Intent(this, SearchActivity::class.java)
                this@LoginActivity.startActivity(Intent)
            }
        })

        binding.lifecycleOwner = this
    }


}