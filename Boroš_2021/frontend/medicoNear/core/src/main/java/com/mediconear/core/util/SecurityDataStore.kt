package com.mediconear.core.util

import android.app.Application
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

abstract class SecurityDataStore {

    protected fun createEncryptedSharedPrefs(fileName: String, application: Application) = EncryptedSharedPreferences.create(
        fileName,
        getMasterKey(),
        application,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    private fun getMasterKey(): String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
}
