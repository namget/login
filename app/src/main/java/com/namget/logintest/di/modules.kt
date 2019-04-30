package com.namget.logintest.di

import com.google.gson.GsonBuilder
import com.namget.diaryLee.data.remote.api.ApiService
import com.namget.logintest.BuildConfig
import com.namget.logintest.data.repository.NetworkRepositoryImpl
import com.namget.logintest.data.repository.Repository
import com.namget.logintest.ui.login.LoginViewModelFactory
import com.namget.logintest.ui.search.SearchViewModelFactory
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
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

        val interceptor = HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
            } else {
                setLevel(HttpLoggingInterceptor.Level.NONE)
            }
        } as Interceptor

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder().apply {
            addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            addConverterFactory(GsonConverterFactory.create(gson))
            client(client)
            baseUrl("https://api.github.com/")
        }.build().create(ApiService::class.java)
    }



    single {
        NetworkRepositoryImpl(get()) as Repository
    }

}

val viewModelModule = module {
    factory {
        LoginViewModelFactory(get())
    }

    factory {
        SearchViewModelFactory(get())
    }
}

val appModules = listOf(apiModule, viewModelModule)
