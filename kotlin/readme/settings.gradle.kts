pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        val composeVersion = extra["compose.version"] as String
        val pinpitVersion = extra["pinpit.version"] as String
        id("org.jetbrains.kotlin.jvm").version(kotlinVersion)
        id("org.jetbrains.compose").version(composeVersion)
        id("de.mobanisto.pinpit").version(pinpitVersion)
    }
}
rootProject.name = "pinpit-compose-helloworld"
