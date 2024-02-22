package me.huanmeng.bedwars.util

import me.huanmeng.bedwars.platform.GameWorld
import me.huanmeng.bedwars.platform.WorldPos

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
data class Pos(
    val x: Double, val y: Double, val z: Double
) {
    fun world(world: GameWorld): WorldPos {
        return WorldPos(this, world)
    }

    companion object {
        fun of(x: Double, y: Double, z: Double): Pos {
            return Pos(x, y, z)
        }

        fun of(x: Int, y: Int, z: Int): Pos {
            return Pos(x.toDouble(), y.toDouble(), z.toDouble())
        }
    }
}
