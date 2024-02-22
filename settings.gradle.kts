rootProject.name = "Bedwars"

sequenceOf(
    "common",
    "core",
    "versions/1_8_8"
).forEach { path ->
    val name = if (path.contains("/")) {
        path.replace('/', '-')
    } else path
    include("bedwars-$name")
    project(":bedwars-$name").projectDir = File(path)
}
