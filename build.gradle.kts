import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.21")
        classpath("org.kt3k.gradle.plugin:coveralls-gradle-plugin:2.8.2")
    }
}

plugins {
    id("com.github.ben-manes.versions") version "0.21.0"
    id("io.gitlab.arturbosch.detekt") version "1.0.0-RC14"
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

task("clean", type = Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType(DependencyUpdatesTask::class.java).all {
    resolutionStrategy {
        componentSelection {
            all {
                val rejected = listOf("alpha", "beta", "rc", "cr", "m", "preview")
                    .map { qualifier -> Regex("(?i).*[.-]$qualifier[.\\d-]*") }
                    .any { it.matches(candidate.version) }

                if (rejected) {
                    reject("Release candidate")
                }
            }
        }
    }
}

detekt {
    input = files("$projectDir")

    // To override MaxLineLength:excludeCommentStatements
    config = files("detekt-config.yml")
}
