import Dep.accompanistVersion
import Dep.activityComposeVersion
import Dep.coilVersion
import Dep.composeVersion
import Dep.constraintLayoutComposeVersion
import Dep.gsonVersion
import Dep.hiltComposeNavigationVersion
import Dep.hiltCoreVersion
import Dep.hiltVersion
import Dep.loggingInterceptor
import Dep.pagingComposeVersion
import Dep.retrofitVersion
import Dep.roomVersion
import Dep.timberVersion

plugins {
    id ("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk  = Version.compileSdk

    defaultConfig {
        applicationId  = "com.surfsocial"
        minSdk  =   Version.minSdk
        targetSdk =  Version.targetSdk
        versionCode =  Version.versionCode
        versionName  = Version.versionName

        testInstrumentationRunner  = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary  = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled =  false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility  = JavaVersion.VERSION_1_8
        targetCompatibility =  JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose  = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion  = Dep.composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:${Dep.coreKtxVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${Dep.kotlinVersion}")
    implementation("androidx.appcompat:appcompat:${Dep.appCompatVersion}")

    // compose
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.constraintlayout:constraintlayout-compose:$constraintLayoutComposeVersion")
    implementation("androidx.activity:activity-compose:$activityComposeVersion")
    implementation("androidx.paging:paging-compose:$pagingComposeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")

    // other
    implementation("com.jakewharton.timber:timber:$timberVersion")
    implementation("com.google.code.gson:gson:$gsonVersion")

    // hilt
    implementation("com.google.dagger:hilt-android:${hiltCoreVersion}")
    kapt("com.google.dagger:hilt-compiler:${hiltCoreVersion}")
    kapt("androidx.hilt:hilt-compiler:${hiltVersion}")
    implementation("androidx.hilt:hilt-navigation-compose:${hiltComposeNavigationVersion}")

    //datastore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:${accompanistVersion}")
    implementation("com.google.accompanist:accompanist-insets:${accompanistVersion}")
    implementation("com.google.accompanist:accompanist-pager:${accompanistVersion}")
    implementation("com.google.accompanist:accompanist-pager-indicators:${accompanistVersion}")
    implementation ("com.google.accompanist:accompanist-flowlayout:0.21.4-beta")

    //room
    implementation("androidx.room:room-runtime:${roomVersion}")
    implementation("androidx.room:room-ktx:${roomVersion}")
    kapt("androidx.room:room-compiler:${roomVersion}")

    //coil
    implementation("io.coil-kt:coil-compose:${coilVersion}")

    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$loggingInterceptor")
}

kapt {
    correctErrorTypes = true
}