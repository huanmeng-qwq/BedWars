package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.platform.GameWorld
import me.huanmeng.bedwars.platform.Sidebar
import me.huanmeng.bedwars.platform.User
import java.util.*

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
abstract class Game<TEAM : Team<*>>(internal val gameConfig: GameConfig) {
    abstract val world: GameWorld
    abstract val sidebar: Sidebar

    protected val _users: MutableSet<User> = linkedSetOf()
    protected var gameState: GameState = GameState.WAITING
    protected val _teams: MutableMap<TeamType, TEAM> = mutableMapOf()
    protected val _playerTeams: MutableMap<User, TeamType> = hashMapOf()

    protected var initialize: Boolean = false

    internal lateinit var gameId: GameId

    /*Getter*/
    val users: Set<User>
        get() {
            return Collections.unmodifiableSet(_users)
        }
    val teams: Map<TeamType, TEAM>
        get() {
            return Collections.unmodifiableMap(_teams)
        }
    val playerTeams: Map<User, TeamType>
        get() {
            return Collections.unmodifiableMap(_playerTeams)
        }
    /*Getter end*/

    abstract fun initialize()

    /**
     * @return 如果返回true则代表加入成功
     */
    open fun userJoin(user: User): Boolean {
        if (_users.add(user)) {
            user.teleport(gameConfig.lobbyPos!!.world(world))
            sidebar.addUser(user)
            return true
        }
        return false
    }

    open fun userLeave(user: User) {
        if (_users.remove(user)) {
            sidebar.removeUser(user)
        }
    }

    abstract fun onTick(tick: Int)
}