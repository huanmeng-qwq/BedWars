group = "com.huanmeng-qwq.bedwars"
version = "1.0"

plugins {
    `java-library`
    `kotlin-dsl`
}

allprojects {
    repositories {
        mavenCentral()
        sequenceOf(
            "https://repo.codemc.io/repository/maven-releases/",
            "https://repo.codemc.io/repository/maven-snapshots/",
            "https://repo.codemc.io/repository/maven-public/",
            "https://hub.spigotmc.org/nexus/content/repositories/snapshots/",
            "https://maven.evokegames.gg/snapshots/",
            "https://oss.sonatype.org/content/repositories/snapshots/",
            "https://oss.sonatype.org/content/repositories/central/",
            "https://repo.papermc.io/repository/maven-public/"
        ).forEach {
            maven(it)
        }

        maven("https://jitpack.io/")
    }
    apply(plugin = "java-library")
    apply(plugin = "kotlin")

    tasks.compileJava {
        options.encoding = "UTF-8"
        options.isIncremental = true
        options.compilerArgs.add("-parameters")
    }
    tasks.whenTaskAdded {
        if (name == "shadowJar") {
            tasks.build {
                dependsOn(this@whenTaskAdded)
            }
        }
    }
}
