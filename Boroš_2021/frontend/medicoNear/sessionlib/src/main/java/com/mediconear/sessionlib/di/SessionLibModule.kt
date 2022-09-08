package com.mediconear.sessionlib.di

import com.mediconear.commonui.BuildConfig
import com.mediconear.core.di.BACKGROUND_SCHEDULER
import com.mediconear.sessionlib.auth.AuthHeaderInterceptor
import com.mediconear.sessionlib.auth.TokenAuthenticator
import com.mediconear.sessionlib.service.SessionService
import com.mediconear.sessionlib.source.SessionSource
import com.mediconear.sessionlib.source.SessionSourceImpl
import com.mediconear.sessionlib.store.SessionStore
import com.mediconear.sessionlib.store.SessionStoreImpl
import com.mediconear.sessionlib.usecase.*
import com.squareup.moshi.Moshi
import io.reactivex.Scheduler
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.binds
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val RETROFIT = "RETROFIT"
const val OK_HTTP_CLIENT = "OKHTTP_CLIENT"
const val RETROFIT_WITH_AUTH = "RETROFIT_WITH_AUTH"
const val OK_HTTP_CLIENT_WITH_AUTH = "OK_HTTP_CLIENT_WITH_AUTH"

const val DEFAULT_TIMEOUT_SEC = 25L

fun sessionLibModule(): Module = module {

    single<AuthHeaderInterceptor> { AuthHeaderInterceptor(get()) }

    single<Moshi> {
        Moshi.Builder().build()
    }

    single<CallAdapter.Factory> { RxJava2CallAdapterFactory.create() }
    single<Converter.Factory> { MoshiConverterFactory.create(get()) }

    factory<OkHttpClient>(named(OK_HTTP_CLIENT)) {
        OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
        }.build()
    }

    single { TokenAuthenticator() } binds arrayOf(Authenticator::class, TokenAuthenticator::class)

    factory<OkHttpClient>(named(OK_HTTP_CLIENT_WITH_AUTH)) {
        OkHttpClient.Builder().apply {
            connectTimeout(DEFAULT_TIMEOUT_SEC, TimeUnit.SECONDS)
            readTimeout(DEFAULT_TIMEOUT_SEC, TimeUnit.SECONDS)
            writeTimeout(DEFAULT_TIMEOUT_SEC, TimeUnit.SECONDS)
            authenticator(get())
            addInterceptor(get<AuthHeaderInterceptor>())
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
        }.build()
    }

    factory<Retrofit.Builder> {
        val backgroundScheduler = get<Scheduler>(named(BACKGROUND_SCHEDULER))
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(backgroundScheduler))
            .addConverterFactory(get())
    }

    single(named(RETROFIT)) {
        get<Retrofit.Builder>()
            .baseUrl(BuildConfig.BASE_API_URL)
            .client(get<OkHttpClient>(named(OK_HTTP_CLIENT)))
            .build()
    }

    single(named(RETROFIT_WITH_AUTH)) {
        get<Retrofit.Builder>()
            .baseUrl(BuildConfig.BASE_API_URL)
            .client(get<OkHttpClient>(named(OK_HTTP_CLIENT_WITH_AUTH)))
            .build()
    }

    single { get<Retrofit>(named(RETROFIT)).create(SessionService::class.java) }

    single { SignUp(get(), get()) }
    single { SignIn(get()) }
    single { SignOut(get()) }
    single { QueryUser(get()) }
    single { IsUserDoctor(get()) }
    single { SetIsUserDoctor(get()) }

    single<SessionStore> { SessionStoreImpl(get()) }
    single<SessionSource> { SessionSourceImpl(get(), get()) }
}
