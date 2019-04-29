package com.namget.logintest.data.model

import android.service.autofill.UserData
import com.google.gson.annotations.SerializedName

data class UserDataList(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val UserList: ArrayList<UserData>
)
