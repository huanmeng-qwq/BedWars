rootProject.name = "Bedwars"

sequenceOf(
    "common"
).forEach {
    include("bedwars-$it")
    project(":bedwars-$it").projectDir = File(it)
}
