package com.namget.logintest.ui.search

import android.os.Bundle
import com.namget.logintest.R
import com.namget.logintest.databinding.ActivitySearchBinding
import com.namget.logintest.ui.base.BaseActivity

class SearchActivity : BaseActivity<ActivitySearchBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_search

    override fun init() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    fun initViewModel(){

    }



}