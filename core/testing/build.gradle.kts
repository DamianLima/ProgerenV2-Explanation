plugins {
    alias(libs.plugins.progeren.android.library)
    alias(libs.plugins.progeren.android.hilt)
}

android {
    namespace = "com.android.dlddev.progeren2.core.testing"
}

dependencies {
    api(libs.androidx.junit)
    api(libs.kotlinx.coroutines.test)
    implementation(libs.androidx.test.rules)
    implementation(libs.hilt.android.testing)
}