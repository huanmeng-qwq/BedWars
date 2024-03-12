package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.platform.GameWorld
import me.huanmeng.bedwars.platform.Platform
import me.huanmeng.bedwars.platform.Sidebar
import me.huanmeng.bedwars.platform.User
import me.huanmeng.bedwars.util.Identifier
import java.util.*

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
abstract class Game<TEAM : Team<*>>(
    val gameConfig: GameConfig,
    val platform: Platform<*>,
    var mapId: Identifier
) {
    abstract val world: GameWorld
    abstract val sidebar: Sidebar

    protected val _users: MutableSet<User> = linkedSetOf()
    protected var gameState: GameState = GameState.WAITING
    protected val _teams: MutableMap<TeamType, TEAM> = mutableMapOf()
    protected val _userTeams: MutableMap<User, TeamType> = hashMapOf()

    protected var initialize: Boolean = false

    internal lateinit var gameId: GameId

    /*Getter*/
    val users: Set<User>
        get() {
            return Collections.unmodifiableSet(_users)
        }
    val teamMap: Map<TeamType, TEAM>
        get() {
            return Collections.unmodifiableMap(_teams)
        }
    val teams: Collection<TEAM>
        get() {
            return Collections.unmodifiableCollection(_teams.values)
        }
    val userTeams: Map<User, TeamType>
        get() {
            return Collections.unmodifiableMap(_userTeams)
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

    fun getTeam(teamType: TeamType): TEAM? {
        return _teams[teamType]
    }

    fun getTeamUsers(teamType: TeamType): List<User> {
        return userTeams.filter { it.value == teamType }.map { it.key }
    }

    fun setTeam(user: User, teamType: TeamType) {
        _userTeams[user] = teamType
    }

    fun setTeam(user: User, team: TEAM) {
        _userTeams[user] = team.teamType
    }

    abstract fun onTick(tick: Int)
}