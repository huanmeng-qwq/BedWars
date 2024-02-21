import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
}

group = "com.huanmeng-qwq"
version = "1.0"

dependencies {
    api(libs.adventure.api)
    api(libs.adventure.nbt)
    api(libs.adventure.gson)
    api(libs.adventure.bukkit)

    api(libs.event.api)
    api(libs.event.method)

    api(libs.packetevents.spigot)

    api(libs.scoreboard.api)
    api(libs.scoreboard.packetevent)

    implementation(libs.server8)
}

tasks.processResources {
    val props = mapOf("version" to project.version)
    inputs.properties(props)
    filteringCharset = "UTF_8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}