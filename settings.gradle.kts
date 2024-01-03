enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PlayZoneKmp"
include(":androidApp")
//include(":shared")
include(":common:auth:api")
include(":common:auth:data")
include(":common:auth:presentation")
include(":common:core:api")
include(":common:games:api")
include(":common:games:data")
include(":common:games:presentation")
include(":common:tournaments:api")
include(":common:tournaments:data")
include(":common:tournaments:presentation")
include(":common:umbrella:ios")
include(":common:umbrella:compose")