package com.namget.logintest.ui.login

import android.os.Bundle
import com.namget.logintest.R
import com.namget.logintest.databinding.ActivitySnsBinding
import com.namget.logintest.ui.base.BaseActivity


class SNSActivity : BaseActivity<ActivitySnsBinding>(){
    override val layoutId: Int
        get() = R.layout.activity_sns

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun init() {

    }

}