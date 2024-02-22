package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.util.Identifier
import me.huanmeng.bedwars.util.Pos
import me.huanmeng.bedwars.util.identifier

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
data class GameConfig(
    var mapId: Identifier = identifier("unknown"),
    var lobbyPos: Pos? = null,
    val maxPlayers: Int,
) {
}
