pluginManagement {
    repositories {
        jcenter()
        gradlePluginPortal()
        maven(url="https://dl.bintray.com/jetbrains/kotlin-native-dependencies")
        bintrayKotlinX()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlinx-serialization") {
                useModule("org.jetbrains.kotlin:kotlin-serialization:${requested.version}")
            }
        }
    }
}

// always good to nail down the root project name, because
// the root directory name may be different in some envs (e.g. CI)
// hence the following even makes sense for single-project builds
rootProject.name = "checksum"
