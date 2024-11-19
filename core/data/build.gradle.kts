plugins {
    alias(libs.plugins.progeren.android.library)
    alias(libs.plugins.progeren.android.hilt)
}

android {
    namespace = "com.android.dlddev.progeren2.core.data"
}

dependencies {

    implementation(libs.androidx.datastore.preferences)
    api(project(":core:domain"))
    api(project(":common"))
    api(project(":core:auditoryDatabase"))
    api(project(":core:protocoloDatabase"))
    api(project(":core:dataCommon"))
    api(project(":core:network"))
    implementation(libs.javax.inject)
    implementation(libs.converter.gson)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}