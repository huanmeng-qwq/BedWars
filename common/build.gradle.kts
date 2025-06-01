import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    kotlin("jvm")
}

dependencies {
    api(libs.adventure.api)
    api(libs.adventure.nbt)
    api(libs.adventure.gson)
    api(libs.adventure.logger)
    api(libs.adventure.legacy)

    api(libs.event)

    compileOnlyApi(libs.slf4j.api)
}

tasks.processResources {
    val props = mapOf("version" to project.version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}