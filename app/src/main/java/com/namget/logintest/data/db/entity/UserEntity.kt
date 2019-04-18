package com.namget.logintest.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "eventIcon")
data class UserEntity(@PrimaryKey(autoGenerate = true) val id: Int?, var icon: String = "", var date: String = "")