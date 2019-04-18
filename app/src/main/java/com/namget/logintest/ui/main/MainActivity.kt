package com.namget.logintest.ui.main

import android.os.Bundle
import com.namget.logintest.R
import com.namget.logintest.databinding.ActivityMainBinding
import com.namget.logintest.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun init() {
    }
}
