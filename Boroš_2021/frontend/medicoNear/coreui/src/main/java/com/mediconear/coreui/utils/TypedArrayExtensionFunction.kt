package com.mediconear.coreui.utils

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.annotation.StyleableRes

inline fun AttributeSet.withTypedArray(context: Context, @StyleableRes attrs: IntArray, block: TypedArray.() -> Unit) {
    with(context.obtainStyledAttributes(this, attrs, 0, 0)) {
        block()
        recycle()
    }
}

inline fun TypedArray.withString(index: Int, defaultValue: String = "", block: (String) -> Unit) {
    getString(index)?.let {
        block(it)
    } ?: block(defaultValue)
}