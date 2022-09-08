package com.mediconear.sessionlib.store

import com.mediconear.sessionlib.model.User

interface SessionStore {

    fun saveToken(token: String)

    fun getToken(): String

    fun clearAccessToken()

    fun saveUser(user: User)

    fun getUser(): User

    fun clearUser()

    fun isUserDoctor(): Boolean

    fun setIsUserDoctor(isUserDoctor: Boolean)
}
