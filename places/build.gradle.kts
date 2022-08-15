plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id(Config.ApplyPlugins.GOOGLE_MAPS_SECRETS_PLUGIN)
}

android {
    namespace = "com.bottlerocketstudios.places"
    compileSdk = Config.AndroidSdkVersions.COMPILE_SDK

    defaultConfig {
        minSdk = Config.AndroidSdkVersions.MIN_SDK
        targetSdk = Config.AndroidSdkVersions.COMPILE_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))

    // Utility
    timberDependencies()
    // Places Api
    placesApiDependencies()
    // Koin - Dependency Injection
    koinDependencies()

    androidxStartupDependencies()
}
