plugins {
    kotlin("jvm") version "1.8.0"
    application
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "me.dgahn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("com.amazonaws:aws-lambda-java-core:1.2.1")
    implementation(platform("software.amazon.awssdk:bom:2.19.14"))
    implementation("software.amazon.awssdk:lambda")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    archiveFileName.set("lambda.jar")
    destinationDirectory.set(file("build/dist"))
    configurations = listOf(project.configurations.runtimeClasspath.get())
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("me.dgahn.AppKt")
}