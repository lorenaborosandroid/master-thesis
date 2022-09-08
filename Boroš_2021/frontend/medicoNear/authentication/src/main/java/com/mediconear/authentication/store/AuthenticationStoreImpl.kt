package com.mediconear.authentication.store

import android.app.Application
import android.content.SharedPreferences
import androidx.core.content.edit
import com.mediconear.core.util.SecurityDataStore
import com.mediconear.sessionlib.store.SessionStore

private const val PREFERENCES_NAME = "USER_PASSCODE_PREFERENCES"
private const val USER_PASSCODE = "USER_PASSCODE"
private const val EMPTY_STRING = ""

class AuthenticationStoreImpl(val application: Application, val sessionStore: SessionStore): AuthenticationStore, SecurityDataStore() {

    private val preferences: SharedPreferences = createEncryptedSharedPrefs(PREFERENCES_NAME, application)

    private var cachedUserPasscode = getUserPasscodeFromStore()

    override fun getUserPasscode(): String = cachedUserPasscode

    override fun saveUserPasscode(passcode: String) {
        cachedUserPasscode = passcode
        preferences.edit(commit = true) { putString(USER_PASSCODE + sessionStore.getUser().userId, passcode ) }
    }

    private fun getUserPasscodeFromStore() = preferences.getString(USER_PASSCODE + sessionStore.getUser().userId, EMPTY_STRING) ?: EMPTY_STRING
}
