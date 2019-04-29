package com.namget.logintest.di

import com.google.gson.GsonBuilder
import com.namget.diaryLee.data.remote.api.ApiService
import com.namget.logintest.BuildConfig
import com.namget.logintest.ui.login.LoginViewModelFactory
import com.namget.logintest.ui.search.SearchViewModel
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule: Module = module {

    single {
        val gson = GsonBuilder().setLenient().create()

        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        Retrofit.Builder().apply {
            addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            addConverterFactory(GsonConverterFactory.create(gson))
            client(client)
            baseUrl("https://api.github.com/")
        }.build().create(ApiService::class.java)
    }
}

val viewModelModule = module {
    factory {
        LoginViewModelFactory(get())
    }

    factory {
        SearchViewModel()
    }

}


val appModules = listOf(apiModule, viewModelModule)
