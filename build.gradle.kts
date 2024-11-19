import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    kotlin("jvm") version "2.0.21"
    `java-library`
    `maven-publish` 
}

val versionPrefix = "SNAPSHOT"

val currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.M.d.HHmm"))!!
val versionNumber = "${currentDateTime}-${versionPrefix}"

group = "com.infinitehorizons"
version = versionNumber

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.infinitehorizons"
            artifactId = "emporium-utils"
            version = versionNumber
            from(components.getByName("java"))
        }
    }
    repositories {
        maven {
            name = "local"
            url = uri("${System.getProperty("user.home")}/.m2/repository")
        }
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/InfiniteHorizons-Inc/Emporium-Utils")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("JAVA_TOKEN")
            }
        }
    }
}

tasks.withType<AbstractPublishToMaven> {
    doLast {
        println("Publication released:")
        println("Group: ${publication.groupId}")
        println("Artifact ID: ${publication.artifactId}")
        println("Version: ${publication.version}")
    }
}

