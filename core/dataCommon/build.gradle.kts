plugins {
    alias(libs.plugins.progeren.jvm.library)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(project(":core:domain"))
}