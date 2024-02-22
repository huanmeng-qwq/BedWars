package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.util.Identifier
import me.huanmeng.bedwars.util.Pos
import me.huanmeng.bedwars.util.identifier
import java.util.*

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
data class GameConfig(
    var mapId: Identifier = identifier("unknown"),
    var minPlayers: Int = 6,
    var maxPlayers: Int = 16,

    var lobbyPos: Pos? = null,
    var specPos: Pos? = null,

    var teams: Map<TeamType, TeamConfig> = EnumMap(TeamType::class.java)
)

data class TeamConfig(
    var spawnPos: Pos? = null,
    var spawnerPos: Pos? = null,
    var itemShopPos: Pos? = null,
    var teamShopPos: Pos? = null,
)
