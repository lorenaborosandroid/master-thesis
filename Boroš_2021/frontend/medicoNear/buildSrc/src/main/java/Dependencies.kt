object Kotlin {
    private val core_ktx_version = "1.2.0"

    val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.61"
    val coreKtx = "androidx.core:core-ktx:$core_ktx_version"
}

object Android {
    private val app_compat_version = "1.1.0"

    val appCompat = "androidx.appcompat:appcompat:$app_compat_version"
}

object UI {

    private val material_version = "1.1.0"

    val materialComponents = "com.google.android.material:material:$material_version"
}

object Layout {

    private val constraint_layout_version = "1.1.3"
    private val fragment_container_view_version = "1.2.3"
    private val recycler_view_version = "1.1.0"

    val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraint_layout_version"
    val fragmentContainer = "androidx.fragment:fragment-ktx:$fragment_container_view_version"
    val recyclerView = "androidx.recyclerview:recyclerview:$recycler_view_version"

}

object DI {
    private val koin_version = "2.1.5"

    val koin = "org.koin:koin-core:$koin_version"
    val koinViewModel = "org.koin:koin-android-viewmodel:$koin_version"
}

object RxJava {
    val core = "io.reactivex.rxjava2:rxjava:2.2.17"
    val android = "io.reactivex.rxjava2:rxandroid:2.1.1"
}

object Retrofit {
    private val retrofit_version = "2.3.0"

    val core = "com.squareup.retrofit2:retrofit:$retrofit_version"
    val rxAdapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"
    val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofit_version"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:3.10.0"
}

object Serialization {
    private val moshi_version = "1.9.3"

    val moshi = "com.squareup.moshi:moshi:$moshi_version"
    val moshi_codegen = "com.squareup.moshi:moshi-kotlin-codegen:$moshi_version"
    val moshiAdapters = "com.squareup.moshi:moshi-adapters:$moshi_version"
}


object Log {
    private val timber_version = "4.7.1"

    val timber = "com.jakewharton.timber:timber:$timber_version"
}

object JUnit {
    private val junit_version = "4.13"
    private val test_ext_junit_version = "1.1.1"

    val core = "junit:junit:$junit_version"
    val ext = "androidx.test.ext:junit:$test_ext_junit_version"
}

object Espresso {
    private val espresso_core_version = "3.2.0"

    val core = "androidx.test.espresso:espresso-core:$espresso_core_version"
}

object Security {
    private val security_version = "1.0.0-rc03"
    private val biometrics_version = "1.0.1"

    val cryptography = "androidx.security:security-crypto:$security_version"
    val biometrics = "androidx.biometric:biometric:$biometrics_version"
}
