package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.util.Identifier
import java.util.*

/**
 * 2024/2/21<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
abstract class GameManager<GAME : Game>(val gameFactory: GameFactory<GAME>) {
    private val games: MutableMap<GameId, GAME> = hashMapOf()
    private val gameCfg: MutableMap<Identifier, GameConfig> = mutableMapOf()

    fun createGame(gameConfig: GameConfig? = null, configId: Identifier? = null): GAME {
        require(gameConfig != null || configId != null) {
            "gameConfig or identifier must be not null"
        }
        val config = gameConfig ?: getGameConfig(configId!!)
        require(config != null) {
            return@require "gameConfig is not registered: $configId"
        }
        val game = gameFactory.create(config)
        addGame(game)
        return game
    }

    private fun getGameConfig(identifier: Identifier): GameConfig? {
        return gameCfg[identifier]
    }

    private fun addGame(game: GAME) {
        val gameId = GameId(games.size, game.gameConfig.mapId)
        game.gameId = gameId
        games[gameId] = game
        game.onInit()
    }

    fun getGames(): Collection<GAME> {
        return Collections.unmodifiableCollection(games.values)
    }
}

interface GameFactory<T : Game> {
    fun create(gameConfig: GameConfig): T
}