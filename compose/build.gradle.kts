plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.bottlerocketstudios.compose"
    compileSdk = Config.AndroidSdkVersions.COMPILE_SDK

    defaultConfig {
        minSdk = Config.AndroidSdkVersions.MIN_SDK
        targetSdk = 32

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
    buildFeatures {
        compose = true // Enables Jetpack Compose for this module
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.Compose.COMPOSE_COMPILER_VERSION
    }

}

dependencies {
    implementation(project(mapOf("path" to ":domain")))
    implementation("androidx.navigation:navigation-runtime-ktx:2.4.2")

    // Koin - Dependency Injection
    koinDependencies()

    // LaunchPad - Starting Assets
    launchPadDependencies()

    // Accompanist
    accompanistDependencies()

    // AndroidX
    composeDependencies()

    // Android Maps Compose
    composeMapsDependencies()

    // Coil
    coilDependencies()

    // Utility
    timberDependencies()

    // Test
    junitDependencies()
    mockitoKotlinDependencies()
    truthDependencies()
}
