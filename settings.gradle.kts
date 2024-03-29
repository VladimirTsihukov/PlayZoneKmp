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
include(":common:auth:api")
include(":common:auth:compose")
include(":common:auth:data")
include(":common:auth:presentation")
include(":common:core-compose")
include(":common:core-utils")
include(":common:core:api")
include(":common:games:api")
include(":common:games:compose")
include(":common:games:data")
include(":common:games:presentation")
include(":common:tournaments:api")
include(":common:tournaments:compose")
include(":common:tournaments:data")
include(":common:tournaments:presentation")
include(":common:umbrella:compose")
include(":common:umbrella:ios")