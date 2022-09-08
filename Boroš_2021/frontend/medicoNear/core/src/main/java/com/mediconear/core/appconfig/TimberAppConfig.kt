package com.mediconear.core.appconfig

import android.util.Log
import com.mediconear.core.BuildConfig
import com.mediconear.core.timber.CrashlyticsTree
import com.mediconear.core.timber.DebugTree
import timber.log.Timber

/**
 * Timber app configuration
 */
class TimberAppConfig : AppConfig {
    override fun configure() {
        when (BuildConfig.BUILD_TYPE) {
            "debug" -> Timber.plant(DebugTree())
            "staging" -> Timber.plant(CrashlyticsTree(Log.INFO))
            "release" -> Timber.plant(CrashlyticsTree(Log.WARN))
            else -> throw IllegalStateException("Logging not set for ${BuildConfig.BUILD_TYPE} build type")
        }
    }
}
