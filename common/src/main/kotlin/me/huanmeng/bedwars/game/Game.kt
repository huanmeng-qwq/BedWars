package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.platform.GameWorld
import me.huanmeng.bedwars.platform.Sidebar
import me.huanmeng.bedwars.platform.User

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
abstract class Game(internal val gameConfig: GameConfig) {
    protected val players: MutableSet<User> = linkedSetOf()
    abstract val world: GameWorld
    abstract val sidebar: Sidebar
    protected var gameState: GameState = GameState.WAITING

    internal lateinit var gameId: GameId

    protected abstract fun onInit()

    /**
     * @return 如果返回true则代表加入成功
     */
    open fun userJoin(user: User): Boolean {
        if (players.add(user)) {
            user.teleport(gameConfig.lobbyPos!!.world(world))
            sidebar.addUser(user)
            return true
        }
        return false
    }

    open fun userLeave(user: User) {
        if (players.remove(user)) {
            sidebar.removeUser(user)
        }
    }

    abstract fun onTick(tick: Int)
}