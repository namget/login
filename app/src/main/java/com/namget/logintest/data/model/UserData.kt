package com.namget.logintest.data.model

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("login")
    val loginId: String,
    @SerializedName("html_url")
    val repoUrl: String,
    @SerializedName("score")
    val repoScore: Double
)