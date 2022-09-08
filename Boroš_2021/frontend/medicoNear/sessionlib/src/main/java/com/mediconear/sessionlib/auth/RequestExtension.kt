package com.mediconear.sessionlib.auth

import okhttp3.Request

private const val AUTH_HEADER = "Authorization"
private const val BEARER_PREFIX = "Bearer"

fun Request.newRequestWithAccessToken(accessToken: String): Request =
    newBuilder()
        .header(AUTH_HEADER, "$BEARER_PREFIX $accessToken")
        .build()

fun Request.isWithAccessToken(): Boolean {
    val header = header(AUTH_HEADER)
    return header != null && header.startsWith(BEARER_PREFIX)
}
