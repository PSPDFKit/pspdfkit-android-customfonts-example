/*
 *   Copyright © 2018-2026 PSPDFKit GmbH. All rights reserved.
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
    compileSdk = 36

    defaultConfig {
        applicationId = namespace
        minSdk = 23
        targetSdk = compileSdk

        versionName = "11.0.0"
        versionCode = 146157
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
        disable += setOf("ObsoleteLintCustomCheck", "AndroidGradlePluginVersion")
        // "GradleDependency" needs to be on a separate line because of gradle_lint.sh CI script
        disable.add("GradleDependency")
    }
    packaging {
        resources {
            excludes += "/META-INF/versions/9/OSGI-INF/MANIFEST.MF"
        }
    }
}

dependencies {

    // Nutrient is integrated from the Nutrient Maven repository. See the `repositories` block at the beginning
    // of this file, which shows how to set up the repository in your app.
    implementation("io.nutrient:nutrient:11.0.0")
}
