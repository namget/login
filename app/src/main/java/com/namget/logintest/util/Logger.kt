package com.namget.logintest.util

import android.util.Log

class Logger {

    fun d(t: Throwable) {
        Log.d("d", t.toString())
    }

    fun e(t: Throwable) {
        Log.e("e", t.toString())
    }

}
