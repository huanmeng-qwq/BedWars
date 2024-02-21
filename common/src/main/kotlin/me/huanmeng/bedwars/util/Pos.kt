package me.huanmeng.bedwars.util

import org.bukkit.Location
import org.bukkit.World

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
data class Pos(
    val x: Double, val y: Double, val z: Double
) {
    fun toBukkit(world: World): Location {
        return Location(world, x, y, z)
    }

    companion object {
        fun fromBukkit(location: Location): Pos {
            return Pos(location.x, location.y, location.z)
        }

        fun of(x: Double, y: Double, z: Double): Pos {
            return Pos(x, y, z)
        }

        fun of(x: Int, y: Int, z: Int): Pos {
            return Pos(x.toDouble(), y.toDouble(), z.toDouble())
        }
    }
}
