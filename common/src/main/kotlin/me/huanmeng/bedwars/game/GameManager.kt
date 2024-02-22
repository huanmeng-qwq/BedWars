package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.util.Identifier
import java.util.*

/**
 * 2024/2/21<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class GameManager {
    private val games: MutableList<Game> = mutableListOf()
    private val gameCfg: MutableMap<Identifier, GameConfig> = mutableMapOf()

    fun createGame(gameConfig: GameConfig? = null, identifier: Identifier? = null): Game {
        require(gameConfig != null || identifier != null) {
            "gameConfig or identifier must be not null"
        }
        val config = gameConfig ?: getGameConfig(identifier!!)
        require(config != null) {
            return@require "gameConfig is not registered: $identifier"
        }
        val game = Game(config)
        addGame(game)
        return game
    }

    fun getGameConfig(identifier: Identifier): GameConfig? {
        return gameCfg[identifier]
    }

    private fun addGame(game: Game) {
        games.add(game)
        game.onInit()
    }

    fun getGames(): List<Game> {
        return Collections.unmodifiableList(games)
    }
}