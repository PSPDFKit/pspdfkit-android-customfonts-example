
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application") version "9.4.1" apply false
    // Not applied: this only puts Kotlin 2.4.10 on the build classpath for AGP's built-in Kotlin, which would
    // otherwise compile with an older bundled version that can't read the SDK's Kotlin metadata. Keep it equal
    // to `kotlin` in android/gradle/libs.versions.toml (tools/validation/dependency_version_match_check.sh checks).
    id("org.jetbrains.kotlin.android") version "2.4.10" apply false
}

subprojects {
    pluginManager.withPlugin("org.jetbrains.kotlin.android") {
        tasks.withType<KotlinCompile>().configureEach {
            compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
        }
    }
}
