package me.huanmeng.bedwars.platform

import me.huanmeng.bedwars.util.Pos

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
data class WorldPos(
    val pos: Pos,
    val world: GameWorld
) {
}