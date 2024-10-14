import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    `maven-publish`
    signing
}

publishing {
    // Configure all publications
    publications.withType<MavenPublication> {
        // Stub javadoc.jar artifact
        artifact(tasks.register("${name}JavadocJar", Jar::class) {
            archiveClassifier.set("javadoc")
            archiveAppendix.set(this@withType.name)
        })

        // Provide artifacts information required by Maven Central
        pom {
            name.set("Kotlin Multiplatform Wifi Connection Library")
            description.set("Library For connection the device to WiFi Networks")
            url.set("https://github.com/mattiascibien/kmm-wifi-connect")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    id.set("MattiasCibien")
                    name.set("Mattias Cibien")
                    organization.set("Mattias Cibien")
                    organizationUrl.set("https://www.mattiascibien.net")
                }
            }
            scm {
                url.set("https://github.com/mattiascibien/kmm-wifi-connect")
            }
        }
    }
}

signing {
    sign(publishing.publications)
}
