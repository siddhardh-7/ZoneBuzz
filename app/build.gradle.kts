plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    // Hilt
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

    // KSP
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.siddhardhadarsi.zonebuzz"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.siddhardhadarsi.zonebuzz"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Room Database
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)                    // To use Kotlin Symbol Processing (KSP)
    implementation(libs.androidx.room.ktx)              // Kotlin Extensions and Coroutines support for Room

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // LifeCycle
    implementation(libs.androidx.lifecycle.viewmodel.ktx)           // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.compose)       // ViewModel utilities for Compose
    implementation(libs.androidx.lifecycle.runtime.compose)         // Lifecycle utilities for Compose
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)    // Saved state module for ViewModel
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}