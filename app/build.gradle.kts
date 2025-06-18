/*
 *   Copyright © 2018-2025 PSPDFKit GmbH. All rights reserved.
 *
 *   The PSPDFKit Sample applications are licensed with a modified BSD license.
 *   Please see License for details. This notice may not be removed from this file.
 */

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "com.pspdfkit.example.customfonts"
    compileSdk = 35

    defaultConfig {
        applicationId = namespace
        minSdk = 21
        targetSdk = compileSdk

        versionName = "10.4.0"
        versionCode = 143423
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
    lint {
        warningsAsErrors = true
        disable.add("ObsoleteLintCustomCheck")
        // "GradleDependency" needs to be on a separate line because of gradle_lint.sh CI script
        disable.add("GradleDependency")
    }
}

dependencies {

    // Nutrient is integrated from the Nutrient Maven repository. See the `repositories` block at the beginning
    // of this file, which shows how to set up the repository in your app.
    implementation("io.nutrient:nutrient:10.4.0")
}
