plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:api"))
                implementation(project(":common:games:api"))
                implementation(project(":common:core"))
                implementation(Dependencies.Kodein.core)
            }
        }
    }
}