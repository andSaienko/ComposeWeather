plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("app.cash.paparazzi")
}

android {
    namespace = "com.weather.app.composeweather"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.weather.app.composeweather"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.5"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.1.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Volley
    implementation("com.android.volley:volley:1.2.1")
    //Lottie
    implementation("com.airbnb.android:lottie-compose:6.0.0")
    //Coil
    implementation("io.coil-kt:coil-compose:2.5.0")
    testImplementation("io.coil-kt:coil-test:2.5.0")
    //Pager
    implementation("com.google.accompanist:accompanist-pager:0.25.1")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.19.0")
    //Koin
    implementation("io.insert-koin:koin-androidx-compose:3.4.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // OkHttp
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    // GSON
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}