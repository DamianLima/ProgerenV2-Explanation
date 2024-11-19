plugins {
    alias(libs.plugins.progeren.android.library)
    alias(libs.plugins.progeren.android.room)
}

android {
    namespace = "com.android.dlddev.progeren2.core.databasecommon"
}

dependencies {
    api(project(":core:domain"))
    api(libs.converter.gson)
}