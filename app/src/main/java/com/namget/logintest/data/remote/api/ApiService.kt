package com.namget.diaryLee.data.remote.api

import com.namget.logintest.data.model.UserDataList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //sample
    @GET("search/users")
    fun getUserList(@Query("q") searchName: String, @Query("page") page : Int): Single<UserDataList>

}