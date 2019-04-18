package com.namget.logintest.util
import android.app.Activity
import android.util.Log
import com.namget.logintest.BuildConfig


fun Activity.loge(message : String) = {
    if(BuildConfig.DEBUG){
        Log.e(this::class.java.simpleName,message)
    }
}


fun Activity.logd(message : String){
    if(BuildConfig.DEBUG){
        Log.d(this::class.java.simpleName,message)
    }
}


