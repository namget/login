package com.namget.logintest.util

import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

fun String.hasSpecialCharacter(): Boolean = !Pattern.matches("^[a-zA-Z0-9]*\$", this)
fun String.isMaximumLength(textInputLayout: TextInputLayout): Boolean = this.length > textInputLayout.counterMaxLength