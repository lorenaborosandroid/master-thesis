package com.mediconear.core.appconfig

import org.koin.android.BuildConfig

/**
 * Crashlytics app configuration
 */
class CrashlyticsAppConfig : AppConfig {
    override fun configure() {
        when (BuildConfig.BUILD_TYPE) {
            "debug" -> Unit
            "staging", "release" -> Unit
            /*
            TODO
            Replace with this once we get google-services.json
            "staging", "release" -> FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
             */
            else -> throw IllegalStateException("Crashlytics configuration not set for ${BuildConfig.BUILD_TYPE} build type")
        }
    }
}
