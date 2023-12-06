buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath("app.cash.paparazzi:paparazzi-gradle-plugin:1.3.1")
    }
}

plugins {
    id("com.android.application") version "8.1.4" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("app.cash.paparazzi") version "1.3.1" apply false
    id("com.android.library") version "8.1.4" apply false
}