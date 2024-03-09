package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.platform.GameWorld
import me.huanmeng.bedwars.platform.Platform
import me.huanmeng.bedwars.platform.Sidebar
import me.huanmeng.bedwars.platform.User
import me.huanmeng.bedwars.util.Identifier

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
open class BedwarsGame(
    gameConfig: GameConfig,
    platform: Platform<*>,
    mapId: Identifier
) : Game<BedwarsTeam>(gameConfig, platform, mapId) {
    override val world: GameWorld = TODO()
    override var sidebar: Sidebar

    private val scoreMap: MutableMap<User, UserScore> = hashMapOf()

    var age: Int = 0
    var startTick = 0
    var currentStateTick = 0

    fun getUserScore(user: User): UserScore {
        require(scoreMap.containsKey(user)) {
            "User not in game"
        }
        return scoreMap.get(user)!!
    }

    override fun initialize() {
        require(!initialize) {
            "Game has been initialized"
        }
        sidebar = platform.createSideBar()
        initialize = true
    }

    override fun userJoin(user: User): Boolean {
        if (super.userJoin(user)) {
            scoreMap[user] = UserScore()
            return true
        }
        return false
    }

    override fun onTick(tick: Int) {
        ++age
        /*temp*/
        val wait = 20 * 10
        if (_users.size >= 2) {
            ++currentStateTick
            if (currentStateTick >= wait) {
                onGameStart(tick)
            }
        }
        /*temp*/
    }

    open fun onGameStart(tick: Int) {
        if (gameState != GameState.WAITING) return
        gameState = GameState.STARTED
        age = 0
        startTick = tick
        teams.forEach {
            it.initialize()
        }
    }

}