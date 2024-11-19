plugins {
    alias(libs.plugins.progeren.android.library)
    alias(libs.plugins.progeren.android.hilt)
    alias(libs.plugins.progeren.android.room)
}

android {
    namespace = "com.android.dlddev.progeren2.core.auditorydatabase"
}

dependencies {

    implementation(project(":core:dataCommon"))
    implementation(project(":core:databaseCommon"))
    androidTestImplementation(project(":core:testing"))
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.truth)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.kotlinx.coroutines.test)
}