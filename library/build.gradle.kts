import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.publish)
}

kotlin {
    //jvm()
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
        dependencies {
            implementation(libs.androidx.startup.runtime)
        }
    }
    //iosX64()
    iosArm64()
    iosSimulatorArm64()
    //linuxX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "net.mattiascibien.kmmwificonnect"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

publishing {
    repositories {
        maven {
            name = "githubPackages"
            url = uri("https://maven.pkg.github.com/mattiascibien/kmm-connect-wifi")
            credentials(PasswordCredentials::class)
        }
    }
}

mavenPublishing {
    configure(
        KotlinMultiplatform(
            javadocJar = JavadocJar.Empty(),
            sourcesJar = true,
            androidVariantsToPublish = listOf("debug", "release")
        )
    )

    coordinates("net.mattiascibien.kmm-connect-wifi", "kmm-connect-wifi", "0.0.1-SNAPSHOT")

    pom {
        name.set("Kotlin Multiplatform Connect WiFi")
        description.set("Library for connecting to WiFi network in a simple and cross-platform way")
        inceptionYear.set("2024")
        url.set("https://github.com/mattiascibien/kmm-connect-wifi/")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("mattiascibien")
                name.set("Mattias Cibien")
                url.set("https://github.com/mattiascibien/")
            }
        }
        scm {
            url.set("https://github.com/mattiascibien/kmm-connect-wifi/")
            connection.set("scm:git:git://github.com/mattiascibien/kmm-connect-wifi.git")
            developerConnection.set("scm:git:ssh://git@github.com/mattiascibien/kmm-connect-wifi.git")
        }
    }
}