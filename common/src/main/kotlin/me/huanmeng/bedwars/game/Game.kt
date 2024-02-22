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
    private val players: MutableSet<User> = linkedSetOf()
    abstract val world: GameWorld
    abstract val sidebar: Sidebar

    internal lateinit var gameId: GameId

    internal abstract fun onInit()

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

    abstract fun onTick(tick: Long)
}