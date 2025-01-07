pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            plugin("android.application", "com.android.application").version("8.2.2")
            plugin("kotlin.android", "org.jetbrains.kotlin.android").version("1.9.22")
        }
    }
}

rootProject.name = "Healthy_weight_loss"
include(":app")
