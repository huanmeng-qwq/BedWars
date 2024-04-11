package me.huanmeng.bedwars.platform

import me.huanmeng.bedwars.util.Pos
import me.huanmeng.bedwars.util.WorldPos

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
interface GameWorld : PlatformScope {
    override val platform: Platform<*>

    val name: String

    fun getPos(x: Double, y: Double, z: Double): WorldPos = getPos(Pos.of(x, y, z))
    fun getPos(x: Int, y: Int, z: Int): WorldPos = getPos(Pos.of(x, y, z))
    fun getPos(pos: Pos): WorldPos = WorldPos(pos, this)
}