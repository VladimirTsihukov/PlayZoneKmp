plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.tishukoff.playzonekmp.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.tishukoff.playzonekmp.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":common:core"))
    implementation(project(":common:games:api"))
    implementation(project(":common:umbrella:compose"))

    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
}