dependencies {
    implementation(project(":bedwars-core"))
    implementation(libs.server8)

    implementation(libs.packetevents.spigot)

    implementation(libs.scoreboard.api)
    implementation(libs.scoreboard.packetevent)
    implementation(libs.entitylib)
}