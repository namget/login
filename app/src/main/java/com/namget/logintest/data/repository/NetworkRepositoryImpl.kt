package com.namget.logintest.data.repository

import com.namget.diaryLee.data.remote.api.ApiService
import com.namget.logintest.data.model.UserDataList
import io.reactivex.Single

class NetworkRepositoryImpl(val apiService: ApiService) : Repository {
    override fun getUserList(searchName: String, page: Int): Single<UserDataList> {
        return apiService.getUserList(searchName, page)
    }
}