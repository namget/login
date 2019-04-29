package com.namget.logintest.data.repository

import com.namget.logintest.data.model.UserDataList
import io.reactivex.Single

interface Repository {
    fun getUserList(searchName: String): Single<UserDataList>
}