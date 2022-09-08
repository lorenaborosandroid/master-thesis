package com.mediconear.coreui.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.hideKeyboard() {
    clearFocus()
    (context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow(windowToken, 0)
}

fun View.hide() = show(false)

fun View.show(shouldShow: Boolean = true) {
    visibility = if (shouldShow) View.VISIBLE else View.GONE
}