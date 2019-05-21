// Top-level build file where you can add configuration options common to all sub-projects/modules.
import org.gradle.kotlin.dsl.repositories

plugins {
    base
    kotlin("multiplatform") version Versions.kotlin apply false
    id("kotlinx-serialization") version Versions.kotlin apply false
}

allprojects {
    group = "com.github.bschramke"
    version = "0.0.1"

    repositories {
        jcenter()
        bintrayKotlinX()
    }
}