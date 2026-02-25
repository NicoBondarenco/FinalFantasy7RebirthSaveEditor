rootProject.name = "FinalFantasy7RebirthSaveEditor"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        mavenLocal()
    }
}

buildCache {
    local {
        isEnabled = false
        directory = File(rootDir, "build-cache")
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
