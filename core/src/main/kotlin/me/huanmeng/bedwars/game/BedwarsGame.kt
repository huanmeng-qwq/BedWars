package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.platform.GameWorld
import me.huanmeng.bedwars.platform.Platform
import me.huanmeng.bedwars.platform.Sidebar
import me.huanmeng.bedwars.platform.User

/**
 * 2024/2/22<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
open class BedwarsGame(gameConfig: GameConfig, val platform: Platform) : Game(gameConfig) {
    override val world: GameWorld = TODO()
    override var sidebar: Sidebar

    protected val scoreMap: MutableMap<User, UserScore> = hashMapOf()

    var age: Int = 0
    var startTick = 0
    var currentStateTick = 0

    override fun onInit() {
        sidebar = platform.createSideBar()
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
        if (players.size >= 2) {
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
    }

}