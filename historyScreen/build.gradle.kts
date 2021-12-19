plugins {
    id("com.android.library")
    kotlin("android.extensions")
    kotlin("android")
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Modules
    implementation(project(Modules.CORE_MODULE))
    implementation(project(Modules.DATA_MODULE))
    implementation(project(Modules.MODEL_MODULE))

    // Design
    implementation(Dependencies.APPCOMPAT_DEPENDENCY)
    implementation(Dependencies.MATERIAL_DEPENDENCY)

    // Kotlin
    implementation(Dependencies.CORE_KTX_DEPENDENCY)
    implementation(Dependencies.STD_LIB_JDK7_DEPENDENCY)
    implementation(Dependencies.COROUTINES_CORE_DEPENDENCY)
    implementation(Dependencies.COROUTINES_ANDROID_DEPENDENCY)

    // Koin
    implementation(Dependencies.KOIN_CORE_DEPENDENCY)
    implementation(Dependencies.KOIN_ANDROID_DEPENDENCY)
    implementation(Dependencies.KOIN_ANDROID_COMPAT_DEPENDENCY)

    // Test
    testImplementation(Dependencies.JUNIT_DEPENDENCY)
    androidTestImplementation(Dependencies.RUNNER_DEPENDENCY)
    androidTestImplementation(Dependencies.ESPRESSO_CORE_DEPENDENCY)
}