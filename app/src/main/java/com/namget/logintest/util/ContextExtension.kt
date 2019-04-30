package com.namget.logintest.util

import android.content.Context
import android.widget.Toast

fun Context.showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
fun Context.showToast(resId: Int) = Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()