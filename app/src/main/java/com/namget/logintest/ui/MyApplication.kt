package com.namget.logintest.ui

import android.app.Application
import com.namget.logintest.di.appModules
import org.koin.android.ext.android.startKoin

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()

//        val crashlyticsCore = CrashlyticsCore.Builder()
//            .disabled(BuildConfig.DEBUG)
//            .build()
//
//        //crash report
//        if (!BuildConfig.DEBUG) {
//            //fabric crashlytics
//            val fabric = Fabric.Builder(this)
//                .kits(Crashlytics.Builder().core(crashlyticsCore).build())
//                .apply {
//                    if (!BuildConfig.DEBUG) {
//                        debuggable(true)           // Enables Crashlytics debugger
//                    }
//                }.build()
//            if (!Fabric.isInitialized()) {
//                Fabric.with(fabric)
//            }
//        }

        //koin
        startKoin(this, appModules)
    }



}