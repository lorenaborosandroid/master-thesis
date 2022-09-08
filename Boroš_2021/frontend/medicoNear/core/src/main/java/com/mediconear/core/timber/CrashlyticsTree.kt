package com.mediconear.core.timber

/**
 * Logs everything above [minPriorityLevel] to Crashlytics
 */
class CrashlyticsTree(private val minPriorityLevel: Int) : DebugTree() {
    override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
        if (priority < minPriorityLevel) {
            return
        }
        /*
        TODO
        Uncomment once we get google-services.json file
        FirebaseCrashlytics.getInstance().log("$tag $message")
        throwable?.let { FirebaseCrashlytics.getInstance().recordException(it) }
         */
    }
}
