plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
    alias(libs.plugins.hiltPlugin)
}

android {
    namespace = "com.thescud.tasks"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {
    api(projects.tasksApi)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.daggerAndroid)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.hiltCompiler)
    ksp(libs.androidx.room.compiler)
}