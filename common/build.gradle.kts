import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
}

group = "com.huanmeng-qwq"
version = "1.0"

dependencies {
    testImplementation(kotlin("test"))
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.10")
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    val scoreboardLibraryVersion = "2.0.0-RC12"
    compileOnly("com.github.megavexnetwork.scoreboard-library:scoreboard-library-implementation:$scoreboardLibraryVersion")
    val adventureVersion = "4.14.0"
    compileOnly("net.kyori:adventure-api:$adventureVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}