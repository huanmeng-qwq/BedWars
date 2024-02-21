package com.huanmeng.bedwars.game

import com.huanmeng.bedwars.BedwarsPlugin
import net.kyori.adventure.text.Component
import net.megavex.scoreboardlibrary.api.sidebar.Sidebar
import org.bukkit.World
import org.bukkit.entity.Player

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
class Game(private val gameConfig: GameConfig) {
    val players: MutableSet<Player> = linkedSetOf()
    val world: World? = null
    val sidebar: Sidebar by lazy {
        BedwarsPlugin.getInstance().scoreboardLibrary.createSidebar()
    }

    fun onInit() {
        //todo
    }

    /**
     * @return 如果返回true则代表加入成功
     */
    fun userJoin(player: Player): Boolean {
        if (players.add(player)) {
            player.teleport(gameConfig.lobbyPos!!.toBukkit(world!!))
            sendJoinMessage(player)
            sidebar.addPlayer(player)
            return true
        }
        return false
    }

    fun onTick(tick: Long) {
        sidebar.title(Component.text("§e§l起床战争"))
        val list: MutableList<String> = mutableListOf()
        list.add("§f在线玩家: §b${players.size}/${gameConfig.maxPlayers}")
        list.add("§f地图名: §a${gameConfig.mapName}")
        list.forEachIndexed { index, line ->
            sidebar.line(index, Component.text(line))
        }
    }

    fun sendJoinMessage(player: Player) {
        players.forEach {
            it.sendMessage("${player.name}§e加入了游戏！ §f(§b${players.size}/${gameConfig.maxPlayers}§f)")
        }
    }
}