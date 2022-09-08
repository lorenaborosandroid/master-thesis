package com.mediconear.sessionlib.store

import android.app.Application
import android.content.SharedPreferences
import androidx.core.content.edit
import com.mediconear.core.util.SecurityDataStore
import com.mediconear.sessionlib.model.User

private const val PREFERENCES_NAME = "USER_TOKEN_PREFERENCES"
private const val USER_TOKEN = "USER_TOKEN"
private const val EMPTY_STRING = ""

private const val KEY_USER_ID = "userId"
private const val KEY_USER_EMAIL = "userEmail"
private const val KEY_USER_FIRST_NAME = "firstName"
private const val KEY_USER_LAST_NAME = "lastName"
private const val KEY_USER_PHONE_NUMBER = "phoneNumber"
private const val KEY_USER_OIB = "oib"
private const val KEY_USER_DOB = "dob"

private const val KEY_IS_USER_DOCTOR = "isUserDoctor"

class SessionStoreImpl(application: Application) : SessionStore, SecurityDataStore() {

    private val preferences: SharedPreferences = createEncryptedSharedPrefs(PREFERENCES_NAME, application)

    private var cachedUserToken = getUserTokenFromStore()

    private var cachedUser = getUserFromStore()

    private var cachedIsUserDoctor = getIsUserDoctorFromStore()

    override fun getToken(): String = cachedUserToken

    override fun saveToken(token: String) {
        cachedUserToken = token
        preferences.edit(commit = true) { putString(USER_TOKEN, token) }
    }

    private fun getUserTokenFromStore() = preferences.getString(USER_TOKEN, EMPTY_STRING) ?: EMPTY_STRING

    override fun clearAccessToken() {
        cachedUserToken = EMPTY_STRING
        preferences.edit(commit = true) {
            clear()
        }
    }

    override fun saveUser(user: User) {
        cachedUser = user

        with(user) {
            preferences.edit(commit = true) {
                putInt(KEY_USER_ID, userId)
                putString(KEY_USER_EMAIL, email)
                putString(KEY_USER_FIRST_NAME, firstName)
                putString(KEY_USER_LAST_NAME, lastName)
                putString(KEY_USER_PHONE_NUMBER, phoneNumber)
                putString(KEY_USER_OIB, oib)
                putString(KEY_USER_DOB, dob)
                putBoolean(KEY_IS_USER_DOCTOR + userId, cachedIsUserDoctor)
            }
        }
    }

    override fun getUser(): User = cachedUser

    override fun clearUser() {
        cachedUser = User.EMPTY
    }

    override fun isUserDoctor(): Boolean = getIsUserDoctorFromStore()

    override fun setIsUserDoctor(isUserDoctor: Boolean) {
        cachedIsUserDoctor = isUserDoctor
    }

    private fun getUserFromStore(): User =
        User(
            userId = preferences.getInt(KEY_USER_ID, 0),
            email = getStringOrEmpty(KEY_USER_EMAIL),
            firstName = getStringOrEmpty(KEY_USER_FIRST_NAME),
            lastName = getStringOrEmpty(KEY_USER_LAST_NAME),
            oib = getStringOrEmpty(KEY_USER_OIB),
            dob = getStringOrEmpty(KEY_USER_DOB),
            phoneNumber = getStringOrEmpty(KEY_USER_PHONE_NUMBER),
            password = null
        )

    private fun getIsUserDoctorFromStore(): Boolean =
        preferences.getBoolean(KEY_IS_USER_DOCTOR + getUser().userId, false)

    private fun getStringOrEmpty(key: String) = preferences.getString(key, EMPTY_STRING) ?: EMPTY_STRING
}
