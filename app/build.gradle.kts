plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.caso5"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.caso5"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    val sqlite_version = "2.3.0"
    // Java language implementation
    implementation("androidx.sqlite:sqlite:$sqlite_version")

    // Kotlin
    implementation("androidx.sqlite:sqlite-ktx:$sqlite_version")

    // Implementation of the AndroidX SQLite interfaces via the Android framework APIs.
    implementation("androidx.sqlite:sqlite-framework:$sqlite_version")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    //picasso
    implementation("com.squareup.picasso:picasso:2.71828")
    //glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    //splash screen
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.compose.animation:animation-core-android:1.5.4")

    // openstreetmaps
    implementation("org.osmdroid:osmdroid-android:6.1.17")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}