package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.platform.Platform
import me.huanmeng.bedwars.util.Identifier

/**
 * 2024/2/23<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
@Suppress("unused")
class BedwarsGameManager(gameFactory: GameFactory<BedwarsGame>) : GameManager<BedwarsGame>(gameFactory) {
    constructor(platform: Platform<*>) : this(BedwarsGameFactory(platform))
}

class BedwarsGameFactory(private val platform: Platform<*>) : GameFactory<BedwarsGame> {
    override fun create(gameConfig: GameConfig, mapId: Identifier): BedwarsGame {
        return BedwarsGame(gameConfig, platform, mapId)
    }
}