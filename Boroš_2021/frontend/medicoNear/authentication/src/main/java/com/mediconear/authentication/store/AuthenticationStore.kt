package com.mediconear.authentication.store

interface AuthenticationStore {

    fun getUserPasscode(): String

    fun saveUserPasscode(passcode: String)
}
