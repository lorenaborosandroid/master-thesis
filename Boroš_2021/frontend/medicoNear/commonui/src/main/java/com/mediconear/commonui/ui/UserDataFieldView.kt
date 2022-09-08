package com.mediconear.commonui.ui

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.mediconear.commonui.R
import com.mediconear.coreui.utils.withString
import com.mediconear.coreui.utils.withTypedArray
import kotlinx.android.synthetic.main.view_user_data_field.view.*

class UserDataFieldView: ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        parseAttributes(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        parseAttributes(attrs)
    }

    init {
        inflate(context, R.layout.view_user_data_field, this)
    }

    private fun parseAttributes(attrs: AttributeSet?) = attrs?.withTypedArray(context, R.styleable.UserDataFieldView) {
        withString(R.styleable.UserDataFieldView_titleText) {
            commonui_user_data_field_title.text = it
        }
    }

    override fun setEnabled(enabled: Boolean) {
        if(!enabled) {
            commonui_user_data_field.isEnabled = false
            commonui_user_data_field.inputType = AUTOFILL_TYPE_NONE
            commonui_user_data_field.isClickable = false
        } else {
            commonui_user_data_field.isEnabled = true
            commonui_user_data_field.isClickable = true
        }
    }

    fun setText(text: String) {
        commonui_user_data_field.setText(text)
    }

    fun getText(): String? = commonui_user_data_field.text?.toString()
}