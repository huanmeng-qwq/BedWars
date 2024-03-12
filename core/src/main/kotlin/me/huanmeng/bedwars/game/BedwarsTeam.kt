package me.huanmeng.bedwars.game

/**
 * 2024/2/23<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class BedwarsTeam(teamType: TeamType, game: BedwarsGame) : Team<BedwarsGame>(teamType, game) {
    override val teamConfig: TeamConfig
        get() = game.gameConfig.teams[teamType]!!

    override fun initialize() {
        require(!initialize) {
            "Team has been initialized"
        }
        initialize = true
        game.getTeamUsers(teamType).forEach { user ->
            teamConfig.spawnPos?.also { spawnPos ->
                user.teleport(spawnPos.world(game.world))
            }
        }
    }

    override fun onTick(tick: Int) {
        TODO("Not yet implemented")
    }
}