import org.gradle.kotlin.dsl.*

plugins {
    base
    kotlin("multiplatform") version Versions.kotlin
    id("kotlinx-serialization") version Versions.kotlin
}

group = "com.github.bschramke"
version = "0.0.1"

repositories {
    jcenter()
    bintrayKotlinX()
}

kotlin {
    //generate target for jvm
    jvm()

    // iosX64 is for iPhone-Simulator
    // Switch here to iosArm64 (or iosArm32) to build library for iPhone device
    iosX64("ios") {
        compilations["main"].outputKinds("framework")
    }
    
    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(kotlin("stdlib-ios"))
            }
        }
    }

}