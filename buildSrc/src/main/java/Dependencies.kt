object Dependencies {

    // Design
    const val APPCOMPAT_DEPENDENCY =
        "androidx.appcompat:appcompat:${Versions.APPCOMPAT_VERSION}"
    const val MATERIAL_DEPENDENCY =
        "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
    const val CONSTRAINT_LAYOUT_DEPENDENCY =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
    const val SWIPEREFRESH_LAYOUT_DEPENDENCY =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPEREFRESH_LAYOUT_VERSION}"

    // Kotlin
    const val CORE_KTX_DEPENDENCY =
        "androidx.core:core-ktx:${Versions.CORE_KTX_VERSION}"
    const val STD_LIB_JDK7_DEPENDENCY =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.STD_LIB_JDK7_VERSION}"
    const val COROUTINES_CORE_DEPENDENCY =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_CORE_VERSION}"
    const val COROUTINES_ANDROID_DEPENDENCY =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_ANDROID_VERSION}"

    // Retrofit
    const val RETROFIT_DEPENDENCY =
        "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val RETROFIT_CONVERTER_GSON_DEPENDENCY =
        "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_CONVERTER_GSON_VERSION}"
    const val INTERCEPTOR_DEPENDENCY =
        "com.squareup.okhttp3:logging-interceptor:${Versions.INTERCEPTOR_VERSION}"
    const val RETROFIT_ADAPTER_COROUTINES_DEPENDENCY =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.RETROFIT_ADAPTER_COROUTINES_VERSION}"

    // Koin
    const val KOIN_CORE_DEPENDENCY =
        "io.insert-koin:koin-core:${Versions.KOIN_CORE_VERSION}"
    const val KOIN_ANDROID_DEPENDENCY =
        "io.insert-koin:koin-android:${Versions.KOIN_ANDROID_VERSION}"
    const val KOIN_ANDROID_COMPAT_DEPENDENCY =
        "io.insert-koin:koin-android-compat:${Versions.KOIN_ANDROID_COMPAT_VERSION}"

    // Glide
    const val GLIDE_DEPENDENCY =
        "com.github.bumptech.glide:glide:${Versions.GLIDE_VERSION}"
    const val GLIDE_COMPILER_DEPENDENCY =
        "com.github.bumptech.glide:compiler:${Versions.GLIDE_COMPILER_VERSION}"

    // Room
    const val ROOM_RUNTIME_DEPENDENCY =
        "androidx.room:room-runtime:${Versions.ROOM_RUNTIME_VERSION}"
    const val ROOM_COMPILER_DEPENDENCY =
        "androidx.room:room-compiler:${Versions.ROOM_COMPILER_VERSION}"
    const val ROOM_KTX_DEPENDENCY =
        "androidx.room:room-ktx:${Versions.ROOM_KTX_VERSION}"

    // Test
    const val JUNIT_DEPENDENCY =
        "junit:junit:${Versions.JUNIT_VERSION}"
    const val RUNNER_DEPENDENCY =
        "androidx.test:runner:${Versions.RUNNER_VERSION}"
    const val ESPRESSO_CORE_DEPENDENCY =
        "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE_VERSION}"
}