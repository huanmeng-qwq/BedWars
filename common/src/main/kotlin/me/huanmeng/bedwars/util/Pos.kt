package me.huanmeng.bedwars.util

import me.huanmeng.bedwars.platform.GameWorld

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
data class Pos(
    val x: Double, val y: Double, val z: Double,
    val yaw: Float = 0f,
    val pitch: Float = 0f
) {
    fun world(world: GameWorld): WorldPos {
        return WorldPos(this, world)
    }

    val blockPos: BlockPos
        get() = BlockPos(toFloor(x), toFloor(y), toFloor(z))

    companion object {
        fun of(x: Double, y: Double, z: Double): Pos {
            return Pos(x, y, z)
        }

        fun of(x: Int, y: Int, z: Int): Pos {
            return Pos(x.toDouble(), y.toDouble(), z.toDouble())
        }
    }
}

data class WorldPos(
    val world: GameWorld,
    val x: Double, val y: Double, val z: Double
) {
    constructor(pos: Pos, world: GameWorld) : this(world, pos.x, pos.y, pos.z)
}

data class BlockPos(
    val x: Int, val y: Int, val z: Int
) {
    val centerPos: Pos
        get() = Pos(x + .5, y + .5, z + .5)
    val pos: Pos
        get() = Pos(x.toDouble(), y.toDouble(), z.toDouble())

    fun world(world: GameWorld, center: Boolean = false): WorldPos {
        if (center) {
            return WorldPos(centerPos, world)
        }
        return WorldPos(pos, world)
    }

    companion object {
        fun of(x: Int, y: Int, z: Int): BlockPos {
            return BlockPos(x, y, z)
        }
    }
}

fun toFloor(num: Double): Int {
    val floor = num.toInt()
    return if (floor.toDouble() == num) floor else floor - (java.lang.Double.doubleToRawLongBits(num) ushr 63).toInt()
}