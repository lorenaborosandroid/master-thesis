package com.mediconear.commonui.utils

import android.content.Context
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mediconear.commonui.R

fun createMaterialAlertDialog(
    context: Context,
    @StringRes title: Int,
    @StringRes message: Int,
    @StringRes positiveButtonTextResId: Int,
    positiveButtonAction: () -> Unit,
    @StringRes negativeButtonTextResId: Int,
    negativeButtonAction: () -> Unit
): AlertDialog =
    MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
        .setPositiveButton(positiveButtonTextResId) { _, _ -> positiveButtonAction() }
        .setNegativeButton(negativeButtonTextResId) { _, _ -> negativeButtonAction() }
        .setTitle(title)
        .setMessage(message).create()

fun createMaterialAlertDialog(
    context: Context,
    title: String,
    message: String,
    positiveButtonText: String,
    positiveButtonAction: () -> Unit,
    negativeButtonText: String,
    negativeButtonAction: () -> Unit
): AlertDialog =
    MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
        .setPositiveButton(positiveButtonText) { _, _ -> positiveButtonAction() }
        .setNegativeButton(negativeButtonText) { _, _ -> negativeButtonAction() }
        .setTitle(title)
        .setMessage(message).create()
