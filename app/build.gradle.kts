plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
}

android {
    namespace = "com.hope.kotlincountries"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hope.kotlincountries"
        minSdk = 30
        targetSdk = 34
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
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    val navversion = "2.7.6"
    val roomversion = "2.6.1"
    val lifecycleversion = "2.7.0"
    //val supportVersion = "28.0.0"
    val retrofitVersion = "2.9.0"
    val glideVersion = "4.12.0"
    //val rxJavaVersion = "2.2.21"
    val archversion = "2.2.0"


    val preferencesVersion = "1.2.1"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")





    // ViewModel ile ilgili bağımlılıklar
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleversion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleversion")

    // LiveData ile ilgili bağımlılıklar
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleversion")

    // Lifecycle ile ilgili bağımlılıklar
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleversion")
    implementation("androidx.lifecycle:lifecycle-service:$lifecycleversion")

    // ReactiveStreams desteği için
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycleversion")

    // Test için bağımlılıklar
    testImplementation("androidx.arch.core:core-testing:$archversion")
    testImplementation("androidx.lifecycle:lifecycle-runtime-testing:$lifecycleversion")



    implementation("androidx.navigation:navigation-fragment-ktx:$navversion")
    implementation("androidx.navigation:navigation-ui-ktx:$navversion")

    implementation("androidx.room:room-runtime:$roomversion")
    annotationProcessor("androidx.room:room-compiler:$roomversion")
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$roomversion")

    implementation("com.google.android.material:material:1.11.0")

    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")


    implementation("androidx.room:room-rxjava2:$roomversion")

    implementation("com.github.bumptech.glide:glide:$glideVersion")

    implementation("androidx.preference:preference-ktx:$preferencesVersion")

    implementation("androidx.palette:palette-ktx:1.0.0")

    implementation("androidx.databinding:databinding-runtime:8.2.2")






}