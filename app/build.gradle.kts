plugins {
    id("com.android.application")
    kotlin("android.extensions")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.lavsam.lesson6"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Modules
    implementation(project(Modules.CORE_MODULE))
    implementation(project(Modules.DATA_MODULE))
    implementation(project(Modules.HISTORY_SCREEN_MODULE))
    implementation(project(Modules.MODEL_MODULE))
    implementation(project(Modules.UTILS_MODULE))

    // Design
    implementation(Dependencies.APPCOMPAT_DEPENDENCY)
    implementation(Dependencies.MATERIAL_DEPENDENCY)
    implementation(Dependencies.CONSTRAINT_LAYOUT_DEPENDENCY)
    implementation(Dependencies.SWIPEREFRESH_LAYOUT_DEPENDENCY)

    // Kotlin
    implementation(Dependencies.CORE_KTX_DEPENDENCY)
    implementation(Dependencies.STD_LIB_JDK7_DEPENDENCY)
    implementation(Dependencies.COROUTINES_CORE_DEPENDENCY)
    implementation(Dependencies.COROUTINES_ANDROID_DEPENDENCY)

    // Koin
    implementation(Dependencies.KOIN_CORE_DEPENDENCY)
    implementation(Dependencies.KOIN_ANDROID_DEPENDENCY)
    implementation(Dependencies.KOIN_ANDROID_COMPAT_DEPENDENCY)

    // Glide
    implementation(Dependencies.GLIDE_DEPENDENCY)
    kapt(Dependencies.GLIDE_COMPILER_DEPENDENCY)

    // Room
    implementation(Dependencies.ROOM_RUNTIME_DEPENDENCY)
    kapt(Dependencies.ROOM_COMPILER_DEPENDENCY)
    implementation(Dependencies.ROOM_KTX_DEPENDENCY)

    // Test
    testImplementation(Dependencies.JUNIT_DEPENDENCY)
    androidTestImplementation(Dependencies.RUNNER_DEPENDENCY)
    androidTestImplementation(Dependencies.ESPRESSO_CORE_DEPENDENCY)
}