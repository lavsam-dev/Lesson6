plugins {
    id("com.android.library")
    kotlin("android.extensions")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 24
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // Modules
    implementation(project(Modules.MODEL_MODULE))

    // Design
    implementation(Dependencies.APPCOMPAT_DEPENDENCY)

    // Kotlin
    implementation(Dependencies.CORE_KTX_DEPENDENCY)
    implementation(Dependencies.STD_LIB_JDK7_DEPENDENCY)

    // Retrofit
    implementation(Dependencies.RETROFIT_DEPENDENCY)
    implementation(Dependencies.RETROFIT_CONVERTER_GSON_DEPENDENCY)
    implementation(Dependencies.INTERCEPTOR_DEPENDENCY)
    implementation(Dependencies.RETROFIT_ADAPTER_COROUTINES_DEPENDENCY)

    // Room
    implementation(Dependencies.ROOM_RUNTIME_DEPENDENCY)
    kapt(Dependencies.ROOM_COMPILER_DEPENDENCY)
    implementation(Dependencies.ROOM_KTX_DEPENDENCY)

    // Test
    testImplementation(Dependencies.JUNIT_DEPENDENCY)
    androidTestImplementation(Dependencies.RUNNER_DEPENDENCY)
    androidTestImplementation(Dependencies.ESPRESSO_CORE_DEPENDENCY)
}