package com.huanmeng.bedwars.game

import com.huanmeng.bedwars.util.Pos

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
