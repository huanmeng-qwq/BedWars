package me.huanmeng.bedwars.game

import me.huanmeng.bedwars.platform.GameWorld
import me.huanmeng.bedwars.platform.Sidebar
import me.huanmeng.bedwars.platform.User
import net.kyori.adventure.text.Component

/**
 * 2023/9/1<br>
 * Bedwars<br>
 * @author huanmeng_qwq
 */
open class Game(private val gameConfig: GameConfig) {
    val players: MutableSet<User> = linkedSetOf()
    val world: GameWorld? = null
    lateinit var sidebar: Sidebar

    internal fun onInit() {
        //todo
    }

    /**
     * @return 如果返回true则代表加入成功
     */
    fun userJoin(user: User): Boolean {
        if (players.add(user)) {
            user.teleport(gameConfig.lobbyPos!!.world(world!!))
            sendJoinMessage(user)
            sidebar.addUser(user)
            return true
        }
        return false
    }

    fun onTick(tick: Long) {
        sidebar.title(Component.text("§e§l起床战争"))
        val list: MutableList<String> = mutableListOf()
        list.add("§f在线玩家: §b${players.size}/${gameConfig.maxPlayers}")
        list.add("§f地图名: §a${gameConfig.mapId}")
        list.forEachIndexed { index, line ->
            sidebar.line(index, Component.text(line))
        }
    }

    fun sendJoinMessage(user: User) {
        players.forEach {
            val displayName = user.getDisplayName(it)
            it.sendMessage("$displayName§e加入了游戏！ §f(§b${players.size}/${gameConfig.maxPlayers}§f)")
        }
    }
}