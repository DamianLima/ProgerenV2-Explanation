# **Android Build Logic Plugins**

## **Introduction**
This repository contains custom Gradle plugins designed to streamline the build logic for Android 
projects. These plugins simplify common configurations, ensure consistency across modules, 
and optimize build performance, especially for Room, Hilt, and general Android library setups.

---

## **Objective**
The main goals of these custom plugins are:
1. **Centralization**: Avoid repetitive configurations across modules.
2. **Consistency**: Ensure all modules follow the same development standards.
3. **Build Optimization**: Minimize setup and build times with pre-configured tools for Room, Hilt, and other dependencies.
4. **Scalability**: Provide configurations that adapt seamlessly to different module types (libraries, apps, tests).

---

## **Plugins Included**

### **`AndroidHiltConventionPlugin`**
This plugin configures Hilt for Android projects:
- Applies necessary plugins (`ksp`, `dagger.hilt.android.plugin`).
- Manages Hilt dependencies.
- Simplifies dependency injection setup for libraries and applications.

**Main Use**: Facilitates Hilt and KSP integration, ensuring minimal and consistent configuration across modules.

---

### **`AndroidLibraryConventionPlugin`**
This plugin manages specific configurations for Android libraries:
- Applies essential plugins for Android library projects.
- Configures `targetSdk`, `minSdk`, and disables unnecessary tests in modules without test directories.
- Provides a consistent resource prefix based on the module structure.
- Sets conventions for Kotlin usage and JSON serialization.

**Main Use**: Standardizes Android library configurations and removes redundant setup.

---

### **`AndroidRoomConventionPlugin`**
This plugin streamlines Room setup:
- Applies necessary plugins (`androidx.room`, `ksp`).
- Configures Room’s schema directory (`schemaDirectory`).
- Enables Kotlin code generation for Room.
- Manages Room dependencies (`room.runtime`, `room.ktx`, `room.compiler`).

**Main Use**: Simplifies and standardizes Room integration for local database handling in Android projects.

---

## **Internal Functions**
### **`disableUnnecessaryAndroidTests`**
- Verifies the existence of a `src/androidTest` directory in the module.
- Disables instrumented tests if the directory is missing, preventing unnecessary configurations.

### **`configureKotlinAndroid`**
- Configures common settings for Kotlin-based Android projects, such as `compileSdk`, `minSdk`, and Java 8 compatibility.
- Adds compiler arguments like `-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi`.

### **`configureKotlinJvm`**
- Sets build options for non-Android Kotlin projects (e.g., backend or utility modules).
- Configures Java 8 compatibility and Kotlin compiler options.

---

## **Dependencies**
The plugins depend on a version catalog (`libs`) defined in the project:
- **Hilt**: `hilt.android`, `hilt.android.compiler`.
- **Room**: `room.runtime`, `room.ktx`, `room.compiler`.
- **Kotlin Serialization**: `kotlinx-serialization-json`.
- **Tracing**: `androidx.tracing.ktx`.

The catalog is accessed using:
```kotlin
val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
