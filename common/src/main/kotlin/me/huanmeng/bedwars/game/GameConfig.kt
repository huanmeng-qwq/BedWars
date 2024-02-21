package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.util.Pos

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
data class GameConfig(
    var mapName: String = "Unknown",
    var lobbyPos: Pos? = null,
    val maxPlayers: Int,
) {
}
