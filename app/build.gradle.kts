@file:Suppress("ktlint:standard:no-consecutive-comments", "UseTomlInstead")

/*
 *   Copyright © 2018-2026 PSPDFKit GmbH. All rights reserved.
 *
 *   The PSPDFKit Sample applications are licensed with a modified BSD license.
 *   Please see License for details. This notice may not be removed from this file.
 */

plugins {
    id("com.android.application")
}

android {
    namespace = "com.pspdfkit.example.customfonts"
    compileSdk = 36

    defaultConfig {
        applicationId = namespace
        minSdk = 24
        targetSdk = compileSdk

        versionName = "11.6.4"
        versionCode = 148619
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    lint {
        warningsAsErrors = true
        disable += setOf("AndroidGradlePluginVersion")
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

    // Nutrient is published to Maven Central, so no custom repository setup is required.
    implementation("io.nutrient:nutrient-android-sdk:11.6.4")
}
